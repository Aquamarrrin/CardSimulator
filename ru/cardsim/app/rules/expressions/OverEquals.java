package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class OverEquals extends Expression {
    public OverEquals(int value1, int value2) {
        setResult(value1>=value2);
    }
}
