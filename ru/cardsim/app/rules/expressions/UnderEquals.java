package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class UnderEquals extends Expression {
    public UnderEquals(int value1, int value2) {
        setResult(value1<=value2);
    }
}
