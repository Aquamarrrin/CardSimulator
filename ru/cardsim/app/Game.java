package ru.cardsim.app;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Game implements Serializable{
    private String name;
    private Method[] allMethods;
    public Game(String name) {
        this.name=name;
        allMethods = Functions.class.getDeclaredMethods();

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

    public void run(){
        boolean exit = false;
        boolean switchOk = false;
        String commandStr="";
        System.out.println("Запущена игра "+name);
        System.out.println("/Главное меню/Игровое приложение/Игра "+name+"/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (commandStr = in.nextLine()) {
                case "end":
                    exit=true;
                    switchOk = true;
                    System.out.println("Выход из игры");
                    break;
                case "info":
                    switchOk = true;
                    info();
                    break;
                case "help":
                    switchOk = true;
                    help();
                    break;
            }
            if(commandStr.length()>2 && commandStr.charAt(0)=='m' &&  commandStr.charAt(1)==' ' ){
                String[] split = commandStr.split(" ");
                if(split.length>=2) {
                    for (Method m : allMethods) {
                        if(m.getName().equals(split[1]))
                            func(m,null);
                    }
                }
                else{
                    System.out.println("Вы забыли указать имя функции");
                }
            }
            else
            if(!switchOk) {
                System.out.println("Введите корректную команду");
            }
        }
    }

    public void info(){
        System.out.println("Информация об игре "+name);
    }

    private void help(){
        System.out.println("Эта программа создана 5.02.2016");
        System.out.println("help\t\t\tвызов справки");
        System.out.println("end\t\t\tвыход из игры");
        System.out.println("info\t\t\tинформация об игре");
        System.out.println("m [Имя_метода]\t\t\tзапуск определенной функции в игре");

    }
}
