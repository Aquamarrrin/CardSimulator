package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class OverEquals extends Expression {
    public OverEquals(int value1, int value2) {
        setResult(value1>=value2);
    }

    public OverEquals(Expression e, int value1, int value2)
    {
        setId(e.getId());
        setType("OVER_EQUALS");
        setResult(value1>=value2);
        setValue1(value1);
        setValue2(value2);
    }
}
