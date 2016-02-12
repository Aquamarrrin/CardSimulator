package ru.cardsim.app.rules;

import ru.cardsim.app.rules.logicoperators.LogicOperator;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Condition {
    private boolean result;
    private  LogicOperator lo;
    public Condition(LogicOperator lo) {
        this.result = lo.getResult();
        this.lo=lo;
    }

    public boolean getResult(){
        return result;
    }

    public LogicOperator getLo() {
        return lo;
    }

    public void setLo(LogicOperator lo) {
        this.lo = lo;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "result=" + result +
                ", lo=" + lo +
                '}';
    }
}
