package ru.cardsim.app.creator;

import ru.cardsim.app.Functions;
import ru.cardsim.app.entities.Entity;
import ru.cardsim.app.rules.Condition;
import ru.cardsim.app.rules.Rule;
import ru.cardsim.app.rules.expressions.Equals;
import ru.cardsim.app.rules.logicoperators.And;
import ru.cardsim.app.rules.logicoperators.LogicOperator;
import ru.cardsim.app.rules.logicoperators.Not;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Editor {
    private String name;
    private ArrayList<Entity> entities;
    private ArrayList<Rule> rules;
    private int countOfEntities;
    private int countOfRules;
    private Method[] allMethods;

    public Editor(String name) {
        this.name=name;
        this.entities = new ArrayList<>();
        this.rules = new ArrayList<>();
        this.countOfEntities=0;
        this.countOfRules=0;
        allMethods = Functions.class.getDeclaredMethods();
    }

    public void run(){
        boolean exit = false;
        String comandStr="";
        System.out.println("Редактор игры "+name);
        System.out.println("/Главное меню/Редактор/Редактор игры "+name+"/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "end":
                    exit=true;
                    System.out.println("Выход из редактора игры " + name);
                    break;
                case "info":
                    info();
                    break;
                case "help":
                    help();
                    break;
//                default:
//                    System.out.println("Введите корректную команду");
//                    break;
            }

            String[] split = comandStr.split(" ");
            if (split.length>=2 && split[0].equals("cr")){
                //Создаем сущность
                if (split[1].equals("e")){
                    countOfEntities=countOfEntities+1;
                    Entity newEntity = new Entity("new_entity"+countOfEntities, countOfEntities);
                    entities.add(newEntity);
                    System.out.println("Создана сущность с именем new_entity"+countOfEntities+" и id="+countOfEntities);
                }
                else{
                    //Создаем правило
                    if (split[1].equals("r")){
                        countOfRules=countOfRules+1;
                        Condition condition = new Condition(new And(new Equals("str", "str").getResult(), new Not(new Equals(1, 1).getResult()).getResult()));
                        Rule newRule = new Rule(condition, allMethods[0]);
                        newRule.setId(countOfRules+1);
                        rules.add(newRule);
                        System.out.println("Создано правило с условием="+condition.getNameLo()+" и Методом = "+allMethods[1].getName());
                    }
                }
            }
            else{
                if (split.length>=2 && split[0].equals("sh")){
                    //Показать все сущности
                    if (split[1].equals("e")){
                        for (int i=0;i<entities.size();i++) {
                            System.out.println("Имя сущности: "+entities.get(i).getName());
                            System.out.println("id сущности: "+entities.get(i).getId());
                            System.out.println("-----------------------------------------");
                        }
                    }
                    else{
                        //Показать все правила
                        if (split[1].equals("r")){
                            for (int i=0;i<rules.size();i++) {
                                System.out.println("Условие: "+rules.get(i).getCondition().getNameLo());
                                System.out.println("Метод1: "+rules.get(i).getMethod1().getName());
                                System.out.println("id правила: "+rules.get(i).getId());
                                System.out.println("-----------------------------------------");
                            }
                        }
                        else {
                            //Показать конкретную сущность
                            if (checkString(split[1])){
                                int id = Integer.parseInt(split[1]);
                                System.out.println("Имя сущности: "+entities.get(id-1).getName());
                                System.out.println("id сущности: "+entities.get(id-1).getId());
                                System.out.println("-----------------------------------------");
                            }
                            else {
                                //Показать конкретное правило
                                if (split.length>=3 && split[1].equals("r") && checkString(split[2])){
                                    int id = Integer.parseInt(split[2]);
                                    System.out.println("Условие: "+rules.get(id-1).getCondition().getNameLo());
                                    System.out.println("Метод1: "+rules.get(id-1).getMethod1());
                                    System.out.println("id правила: "+rules.get(id-1).getId());
                                    System.out.println("-----------------------------------------");
                                }
                            }
                        }
                    }
                }
                else {
                    //Посмотреть или задать значение свойству конкретной сущности
                    if (split.length>=1 && split[0].contains(".")
                            && checkString(split[0].substring(0,split[0].indexOf(".")))){
                        if(split.length>=2){
                            Method[] methodsOfEntity=Entity.class.getDeclaredMethods();
                            int id = Integer.parseInt(split[0].substring(0,split[0].indexOf(".")));
                            for (Method m : methodsOfEntity) {
                                if(m.getName().contains("set") && m.getName().equals(split[0].substring(split[0].indexOf(".")+1)))
                                    func(entities.get(id-1),m,new Object[]{split[1]});
                            }
                        }
                        else {
                            Method[] methodsOfEntity=Entity.class.getDeclaredMethods();
                            int id = Integer.parseInt(split[0].substring(0,split[0].indexOf(".")));
                            for (Method m : methodsOfEntity) {
                                if(m.getName().contains("get") && m.getName().equals(split[0].substring(split[0].indexOf(".")+1)))
                                    func(entities.get(id-1),m,null);
                            }
                        }
                    }
                    else{
                        //Задать Method1 правилу
                        if (split.length>=2 && checkString(split[0].substring(0,split[0].indexOf(".")))
                                && split[0].contains(".setMethod1")){
                            int id = Integer.parseInt(split[0].substring(0,split[0].indexOf(".")));
                            for (Method m : allMethods) {
                                if(m.getName().equals(split[1]))
                                    rules.get(id).setMethod1(m);
                            }
                        }
                        else {
                            //Задать Method2 правилу
                            if (split.length>=2 && checkString(split[0].substring(0,split[0].indexOf(".")))
                                    && split[0].contains(".setMethod2")){
                                int id = Integer.parseInt(split[0].substring(0,split[0].indexOf(".")));
                                for (Method m : allMethods) {
                                    if(m.getName().equals(split[1]))
                                        rules.get(id).setMethod2(m);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void info(){
        System.out.println("Информация об игре "+name);
    }

    private void help(){
        System.out.println("Эта программа создана 5.02.2016");
        System.out.println("help\t\t\tвызов справки");
        System.out.println("end\t\t\tвыход из редактора игры");
        System.out.println("info\t\t\tинформация об игре");

    }


    public boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void func(Method m, Object[] params) {
        try
        {
            Class c = m.getDeclaringClass();
            Object t = c.newInstance();
            m.setAccessible(true);
            m.invoke(t, params);
        }
        catch (Exception e){
            System.out.println("Ошибка!!!!!!!!!!!!!!!!!");
        }
    }
    private void func(Object t ,Method m, Object[] params) {
        try
        {
            m.setAccessible(true);
            m.invoke(t, params);
        }
        catch (Exception e){
            System.out.println("Ошибка!!!!!!!!!!!!!!!!!");
        }
    }

}
