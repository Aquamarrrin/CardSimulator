package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Deck extends Entity {
    private int countOfCards;

    public Deck(String name, int id) {
        super(name, id);
        this.countOfCards =0;
    }

    public Deck(String name, int id, int countOfCards) {
        super(name, id);
        this.countOfCards = countOfCards;
    }

    public int getCountOfCards() {
        return countOfCards;
    }

    public void setCountOfCards(int countOfCards) {
        this.countOfCards = countOfCards;
    }
}
