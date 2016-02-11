package ru.cardsim.app.rules.logicoperators;

/**
 * Created by bombaster on 09.02.2016.
 */
public class LogicOperator {
    private boolean result;
    private String name;

    public LogicOperator() {
        this.name="LogicOperator()";
    }

    public boolean getResult() {
        return result;
    }

    protected void setResult(boolean result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
