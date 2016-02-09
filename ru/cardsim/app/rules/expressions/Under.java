package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Under extends Expression {
    public Under(int value1, int value2) {
        setResult(value1<value2);
    }
}
