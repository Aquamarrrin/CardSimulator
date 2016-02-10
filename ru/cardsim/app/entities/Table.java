package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Table extends Entity {
    private int countOfPlayers;

    public Table(String name, int id) {
        super(name, id);
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public void setCountOfPlayers(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    public void raiseCountOfPlayers() {
        this.countOfPlayers = this.countOfPlayers+1;
    }
}
