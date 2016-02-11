package ru.cardsim.app.creator;

import ru.cardsim.app.entities.Entity;
import ru.cardsim.app.rules.Rule;

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

    public Editor(String name) {
        this.name=name;
        this.entities = new ArrayList<>();
        this.rules = new ArrayList<>();
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

            String[] split = comandStr.split(" ");
            if (split.length>=2 && split[0].equals("cr")){
                if (split[1].equals("e")){

                }
                else{
                    if (split[1].equals("r")){

                    }
                }
            }
            else{
                if (split.length>=2 && split[0].equals("sh")){
                    if (split[1].equals("e")){

                    }
                    else{
                        if (split[1].equals("r")){

                        }
                        else {
                            if (checkString(split[1])){

                            }
                            else {
                                if (split.length>=3 && split[1].equals("r") && checkString(split[2])){

                                }
                            }
                        }
                    }
                }
                else {
                    if (split.length>=1 && split[0].contains(".")
                            && checkString(split[0].substring(0,split[0].indexOf(".")))){
                        if(split.length>=2){

                        }
                        else {

                        }
                    }
                    else{
                        if (split.length>=2 && checkString(split[0].substring(0,split[0].indexOf(".")))
                                && split[0].contains(".setMethod1")){

                        }
                        else {
                            if (split.length>=2 && checkString(split[0].substring(0,split[0].indexOf(".")))
                                    && split[0].contains(".setMethod2")){

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



}
