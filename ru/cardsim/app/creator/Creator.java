package ru.cardsim.app.creator;

import ru.cardsim.app.Game;

import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Creator {
    public Creator() {

    }

    public void run(){
        boolean exit = false;
        boolean switchOk = false;
        String comandStr="";
        System.out.println("Запущен редактор");
        System.out.println("/Главное меню/Редактор/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "exit":
                    exit=true;
                    switchOk = true;
                    System.out.println("Выход из редактора");
                    break;
                case "help":
                    switchOk = true;
                    help();
                    break;
            }

            if( comandStr.contains("edit")) {
                System.out.println("Запуск редактора");
                String[] splits = comandStr.split(" ");
                if(splits.length>=2) {
                    editGame(splits[1]);
                }
                else{
                    System.out.println("Вы забыли указать имя игры");
                }
            }
            else
                if( comandStr.contains("create")) {
                    System.out.println("Создание игры");
                    String[] splits = comandStr.split(" ");
                    if(splits.length>=2) {
                        createGame(splits[1]);
                    }
                    else{
                        System.out.println("Вы забыли указать имя игры");
                    }
                }
            else
                    if(!switchOk) {
                        System.out.println("Введите корректную команду");
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

    private void help(){
        System.out.println("Эта программа создана 5.02.2016");
        System.out.println("help\t\t\tвызов справки");
        System.out.println("exit\t\t\tвыход из редактора");
        System.out.println("edit [Имя_игры]\t\t\tзапуск редактора конкретной игры");
        System.out.println("create [Имя_игры]\t\t\tсоздание новой игры");

    }
}
