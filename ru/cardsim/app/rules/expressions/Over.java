package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Over extends Expression {
    public Over(int value1, int value2) {
        setResult(value1>value2);
    }
}
