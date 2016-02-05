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
        String comandStr="";
        System.out.println("Запущено игровое приложение");
        System.out.println("/Главное меню/Игровое приложение/");
        Scanner in = new Scanner(System.in);
        while (!exit){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "exit":
                    exit=true;
                    System.out.println("Выход из игрового приложения");
                    break;
            }
            if( comandStr.contains("start")) {
                String[] splits = comandStr.split(" ");
                startGame(splits[1]);
            }
        }
    }

    private void startGame(String nameOfGame){
        System.out.println("Запуск игры");
        Game game = new Game(nameOfGame);
        game.run();
    }
}
