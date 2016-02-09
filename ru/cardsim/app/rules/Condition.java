package ru.cardsim.app.rules;

import ru.cardsim.app.rules.logicoperators.LogicOperator;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Condition {
    private boolean result;
    public Condition(LogicOperator lo) {
        this.result = lo.getResult();
    }

    public boolean getResult(){
        return result;
    }
}
