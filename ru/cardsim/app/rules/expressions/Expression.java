package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Expression<T> {
    private boolean result;
    private int id;
    private String type;
    private T value1;
    private T value2;

    public Expression() {
    }

    public boolean getResult() {
        return result;
    }

    protected void setResult(boolean result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(this.type != null)
        {
            this.value1 = null;
            this.value2 = null;
            this.result = false;
        }
        this.type = type;
    }


    protected void setValue1(T value1) {
        this.value1 = value1;
    }

    protected void setValue2(T value2) {
        this.value2 = value2;
    }


    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
}
