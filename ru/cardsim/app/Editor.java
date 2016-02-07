package ru.cardsim.app;

import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Editor {
    private String name;
    public Editor(String name) {
        this.name=name;
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
                default:
                    System.out.println("Введите корректную команду");
                    break;
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
}
