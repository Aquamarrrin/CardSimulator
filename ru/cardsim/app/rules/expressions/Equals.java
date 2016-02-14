package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Equals extends Expression {

    public Equals(String value1, String value2) {
        setResult(value1.equals(value2));
    }
    public Equals(int value1, int value2) {
        setResult(value1==value2);
    }

    public Equals(Expression e, int value1, int value2)
    {
        setId(e.getId());
        setType("EQUALS");
        setResult(value1==value2);
        setValue1(value1);
        setValue2(value2);
    }

    public Equals(Expression e, String value1, String value2)
    {
        setId(e.getId());
        setType("EQUALS");
        setResult(value1.equals(value2));
        setValue1(value1);
        setValue2(value2);
    }

}
