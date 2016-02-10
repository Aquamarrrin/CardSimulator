package ru.cardsim.app.creator;

import ru.cardsim.app.entities.Entity;
import ru.cardsim.app.rules.Rule;

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
            if (comandStr.contains("cr ")){
                if (comandStr.contains("cr e")){

                }
                else{
                    if (comandStr.contains("cr r")){

                    }
                }
            }
            else{
                if (comandStr.contains("sh ")){
                    if (comandStr.contains("sh e")){

                    }
                    else{
                        if (comandStr.contains("sh r")){

                        }
                        else {
                            if (comandStr.contains("sh <id ") && comandStr.contains(">")){

                            }
                            else {
                                if (comandStr.contains("sh <idr ") && comandStr.contains(">")){

                                }
                            }
                        }
                    }
                }
                else {
                    if (comandStr.contains("<id ") && comandStr.contains(">.<")){
                        if( comandStr.contains("> <")){

                        }
                        else {

                        }
                    }
                    else{
                        if (comandStr.contains("<id ") && comandStr.contains(".setMethod1 <")){

                        }
                        else {
                            if (comandStr.contains("<id ") && comandStr.contains(".setMethod2 <")){

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



}
