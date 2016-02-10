package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Card extends Entity {
    private int value1stSide; //Числовое значение 1й стороны
    private int value2ndSide; //Числовое значение 2й стороны
    private int countOfSides; //Колличество сторон на карте (1 или 2 (как в эволюции например))

    public Card(String name, int id) {
        super(name, id);
        this.value1stSide=0;
        this.value2ndSide=0;
        this.countOfSides=1;
    }

    public Card(String name, int id,int value1stSide) { //Cлучай, когда у карты 1 сторона
        super(name, id);
        this.value1stSide=value1stSide;
        this.value2ndSide=0;
        this.countOfSides=1;
    }

    public Card(String name, int id, int countOfSides, int value1stSide,int value2ndSide) { //Cлучай, когда у карты 2 стороны
        super(name, id);
        this.countOfSides=countOfSides;
        this.value1stSide=value1stSide;
        this.value2ndSide=value2ndSide;
    }

    public int getValue1stSide() {
        return value1stSide;
    }

    public void setValue1stSide(int value1stSide) {
        this.value1stSide = value1stSide;
    }

    public int getValue2ndSide() {
        return value2ndSide;
    }

    public void setValue2ndSide(int value2ndSide) {
        this.value2ndSide = value2ndSide;
    }

    public int getCountOfSides() {
        return countOfSides;
    }

    public void setCountOfSides(int countOfSides) {
        this.countOfSides = countOfSides;
    }
}
