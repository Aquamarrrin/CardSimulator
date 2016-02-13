package ru.cardsim.app.rules.expressions;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Expression {
    private boolean result;
    private int id;

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
}
