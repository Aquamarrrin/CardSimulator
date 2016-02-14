package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Over extends Expression {
    public Over(int value1, int value2) {
        setResult(value1>value2);
    }

    public Over(Expression e, int value1, int value2)
    {
        setId(e.getId());
        setType("OVER");
        setResult(value1>value2);
    }
}
