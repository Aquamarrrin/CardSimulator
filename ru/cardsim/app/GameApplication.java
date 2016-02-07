package ru.cardsim.app;

import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class GameApplication {
    public GameApplication() {

    }

    public void run(){
        boolean exit = false;
        boolean switchOk = false;
        String comandStr="";
        System.out.println("Запущено игровое приложение");
        System.out.println("/Главное меню/Игровое приложение/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "exit":
                    exit=true;
                    switchOk = true;
                    System.out.println("Выход из игрового приложения");
                    break;
                case "help":
                    switchOk = true;
                    help();
                    break;
            }
            if( comandStr.contains("start")) {
                String[] splits = comandStr.split(" ");
                if(splits.length>=2) {
                    startGame(splits[1]);
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

    private void startGame(String nameOfGame){
        System.out.println("Запуск игры");
        Game game = new Game(nameOfGame);
        game.run();
    }

    private void help(){
        System.out.println("Эта программа создана 5.02.2016");
        System.out.println("help\t\t\tвызов справки");
        System.out.println("exit\t\t\tвыход из игрового приложения");
        System.out.println("start [Имя_игры]\t\t\tзапуск конкретной игры");

    }
}
