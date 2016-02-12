package ru.cardsim.app.creator;

import ru.cardsim.app.Functions;
import ru.cardsim.app.entities.Entity;
import ru.cardsim.app.rules.Condition;
import ru.cardsim.app.rules.Rule;
import ru.cardsim.app.rules.logicoperators.LogicOperator;

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
        this.name = name;
        this.entities = new ArrayList<>();
        this.rules = new ArrayList<>();
        this.countOfEntities = 0;
        this.countOfRules = 0;
        allMethods = Functions.class.getDeclaredMethods();
    }

    public void run() {
        boolean exit = false;
        String comandStr = "";
        System.out.println("Редактор игры " + name);
        System.out.println("/Главное меню/Редактор/Редактор игры " + name + "/");
        Scanner in = new Scanner(System.in);
        while (!exit) {
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "end":
                    exit = true;
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
            if (split.length >= 2 && split[0].equals("cr")) {
                if (split[1].equals("e")) {
                    //Создаем сущность
                    createEntity();
                } else if (split[1].equals("r")) {
                    //Создаем правило
                    createRule();
                } else if (split[1].equals("c")) {
                    //Создаем условие

                }
            } else if (split.length >= 2 && split[0].equals("sh")) {
                if (split[1].equals("e")) {
                    //Показать все сущности
                    showAllEntities();
                } else if (split[1].equals("r") && split.length == 2) {
                    //Показать все правила
                    showAllRules();
                } else if (checkString(split[1])) {
                    //Показать конкретную сущность
                    showEntity(split[1]);
                } else if (split.length >= 3 && split[1].equals("r") && checkString(split[2])) {
                    //Показать конкретное правило
                    showRule(split[2]);
                }
            } else if (split.length >= 1 && split[0].contains(".")
                            && checkString(split[0].substring(0, split[0].indexOf(".")))) {
                if (split.length >= 2) {
                    //Задать значение свойству конкретной сущности
                    setPropertyValue(split);
                } else {
                    //Посмотреть значение свойства конкретной сущности
                    getPropertyValue(split[0]);
                }
            } else if (split.length >= 2 && checkString(split[0].substring(0, split[0].indexOf(".")))
                        && split[0].contains(".setMethod1")) {
                    //Задать Method1 правилу
                    setRuleMethod1(split);
                } else if (split.length >= 2 && checkString(split[0].substring(0, split[0].indexOf(".")))
                    && split[0].contains(".setMethod2")) {
                //Задать Method2 правилу
                setRuleMethod2(split);
            }
        }
    }

    //Задать правило второй метод
    private void setRuleMethod2(String[] split) {
        int id = Integer.parseInt(split[0].substring(0, split[0].indexOf(".")));
        for (Method m : allMethods) {
            if (m.getName().equals(split[1]))
                rules.get(id).setMethod2(m);
        }
    }

    //Задать правилу первый метод
    private void setRuleMethod1(String[] split) {
        int id = Integer.parseInt(split[0].substring(0, split[0].indexOf(".")));
        for (Method m : allMethods) {
            if (m.getName().equals(split[1]))
                rules.get(id).setMethod1(m);
        }
    }

    //Получить значение свойства
    private void getPropertyValue(String string) {
        Method[] methodsOfEntity = Entity.class.getDeclaredMethods();
        int id = Integer.parseInt(string.substring(0, string.indexOf(".")));
        for (Method m : methodsOfEntity) {
            if (m.getName().contains("get") && m.getName().equals(string.substring(string.indexOf(".") + 1)))
                try {
                    System.out.println(func(entities.get(id - 1), m, null));
                }catch (Exception e)
                {
                    System.out.println("Данной сущности не существует!");
                }
        }
    }

    //Задать значение свойству
    private void setPropertyValue(String[] split) {
        Method[] methodsOfEntity = Entity.class.getDeclaredMethods();
        int id = Integer.parseInt(split[0].substring(0, split[0].indexOf(".")));
        for (Method m : methodsOfEntity) {
            if (m.getName().contains("set") && m.getName().equals(split[0].substring(split[0].indexOf(".") + 1)))
                func(entities.get(id - 1), m, new Object[]{split[1]});
        }
    }

    //Показать конкретное правило
    private void showRule(String string) {
        try{
            int id = Integer.parseInt(string);
            System.out.println("Условие: " + rules.get(id - 1).getCondition().toString());
            System.out.println("Метод1: " + rules.get(id - 1).getMethod1().getName());
            System.out.println("id правила: " + rules.get(id - 1).getId());
            System.out.println("-----------------------------------------");
        } catch (Exception e)
        {
            System.out.println("Такого правила не существует!");
        }
    }

    //Показать конкретную сущность
    private void showEntity(String string) {
        try {
            int id = Integer.parseInt(string);
            System.out.println("Имя сущности: " + entities.get(id - 1).getName());
            System.out.println("id сущности: " + entities.get(id - 1).getId());
            System.out.println("-----------------------------------------");
        } catch (Exception e)
        {
            System.out.println("Такой сущности не существует!");
        }
    }

    //Вывести все правила в терминал
    private void showAllRules() {
        for (int i = 0; i < rules.size(); i++) {
            System.out.println("Условие: " + rules.get(i).getCondition().toString());
            System.out.println("Метод1: " + rules.get(i).getMethod1().getName());
            System.out.println("id правила: " + rules.get(i).getId());
            System.out.println("-----------------------------------------");
        }
    }

    //Вывести все сущности в терминал
    private void showAllEntities() {
        for (int i = 0; i < entities.size(); i++) {
            System.out.println("Имя сущности: " + entities.get(i).getName());
            System.out.println("id сущности: " + entities.get(i).getId());
            System.out.println("-----------------------------------------");
        }
    }

    //Создаем правило
    private void createRule() {
        countOfRules = countOfRules + 1;
        Condition condition = new Condition(new LogicOperator());
        Rule newRule = new Rule(condition, allMethods[0]);
        newRule.setId(countOfRules);
        rules.add(newRule);
        System.out.println("Создано правило c Методом = " + allMethods[1].getName());
    }

    //Создаем сущность
    private void createEntity() {
        countOfEntities = countOfEntities + 1;
        Entity newEntity = new Entity("new_entity" + countOfEntities, countOfEntities);
        entities.add(newEntity);
        System.out.println("Создана сущность с именем new_entity" + countOfEntities + " и id=" + countOfEntities);
    }

    private void createCondition(){

    }

    //Показать информацию о игре
    public void info() {
        System.out.println("Информация об игре " + name);
    }

    //Показать справку по командам данного раздела
    private void help() {
        System.out.println("help\t\t\t\t\t\tвызов справки");
        System.out.println("end\t\t\t\t\t\tвыход из редактора игры");
        System.out.println("info\t\t\t\t\t\tинформация об игре");
        System.out.println("cr e\t\t\t\t\t\tсоздать пустую сущность");
        System.out.println("cr r\t\t\t\t\t\tсоздать правило");
        System.out.println("cr c\t\t\t\t\t\tсоздать условие");
        System.out.println("sh e\t\t\t\t\t\tпоказать все сущности");
        System.out.println("sh r\t\t\t\t\t\tпоказать все правила");
        System.out.println("sh с\t\t\t\t\t\tпоказать все условия");
        System.out.println("sh <id>\t\t\t\t\t\tпоказать конкретную сущность");
        System.out.println("sh r <id>\t\t\t\t\t\tпоказать конкретное правило");

    }



    //Проверяет, является ли строка числом
    public boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Вызывает любую функцию
    private Object func(Method m, Object[] params) {
        try {
            Class c = m.getDeclaringClass();
            Object t = c.newInstance();
            m.setAccessible(true);
            Object obj = m.invoke(t, params);
            return obj;
        } catch (Exception e) {
            System.out.println("Ошибка!!!!!!!!!!!!!!!!!");
            return null;
        }
    }

    private Object func(Object t, Method m, Object[] params) {
        try {
            m.setAccessible(true);
            m.invoke(t, params);
            Object obj = m.invoke(t, params);
            return obj;
        } catch (Exception e) {
            System.out.println("Ошибка!!!!!!!!!!!!!!!!!");
            return null;
        }
    }

}
