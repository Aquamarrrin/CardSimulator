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
        String comandStr="";
        System.out.println("Запущена игра "+name);
        System.out.println("/Главное меню/Игровое приложение/Игра "+name+"/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "end":
                    exit=true;
                    System.out.println("Выход из игры");
                    break;
                case "info":
                    info();
                    break;
            }
            if(comandStr.length()>2 && comandStr.charAt(0)=='m' &&  comandStr.charAt(1)==' ' ){
                String[] split = comandStr.split(" ");
                for (Method m : allMethods) {
                    if(m.getName().equals(split[1]))
                        func(m,null);
                }
            }
        }
    }

    public void info(){
        System.out.println("Информация об игре "+name);
    }
}
