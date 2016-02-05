package ru.cardsim.app;

import java.util.Scanner;

/**
 * Created by bombaster on 05.02.2016.
 */
public class Terminal {
    public Terminal() {
    }

    public void run(){
        String comandStr="";
        Scanner in = new Scanner(System.in);
        System.out.println("/Главное меню/");
        while (true){
            System.out.print(">");
            switch (comandStr = in.nextLine()) {
                case "help":
                    help();
                    break;
                case "exit":
                    System.out.println("Завершение работы приложения");
                    System.exit(1);
                    break;
                case "creator":
                    createCreator();
                    break;
                case "game":
                    createGame();
                    break;
            }
        }
    }

    private void help(){
        System.out.println("Эта программа создана 5.02.2016");
        System.out.println("help\t\t\tвызов справки");
        System.out.println("exit\t\t\tвыход из программы");
        System.out.println("creator\t\t\tзапуск редактора карточной игры");
        System.out.println("game\t\t\tзапуск игрового приложеия");

    }

    private void createGame(){
        GameApplication gameApp = new GameApplication();
        gameApp.run();
    }

    private void createCreator(){
        Creator creator = new Creator();
        creator.run();
    }
}
