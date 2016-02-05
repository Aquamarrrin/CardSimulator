package ru.cardsim.app;

import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Creator {
    public Creator() {

    }

    public void run(){
        boolean exit = false;
        String comandStr="";
        System.out.println("Запущен редактор");
        System.out.println("/Главное меню/Редактор/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "exit":
                    exit=true;
                    System.out.println("Выход из редактора");
                    break;
            }

            if( comandStr.contains("edit")) {
                System.out.println("Запуск редактора");
                String[] splits = comandStr.split(" ");
                editGame(splits[1]);
            }

            if( comandStr.contains("create")) {
                System.out.println("Создание игры");
                String[] splits = comandStr.split(" ");
                createGame(splits[1]);
            }
        }
    }

    public void createGame(String nameOfGame){
        Game game = new Game(nameOfGame);
    }

    public void editGame(String nameOfGame){
        Editor editor = new Editor(nameOfGame);
        editor.run();
    }
}
