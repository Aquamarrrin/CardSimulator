package ru.cardsim.app.rules.logicoperators;

/**
 * Created by bombaster on 09.02.2016.
 */
public class And extends LogicOperator {
    public And(boolean value1, boolean value2) {
        super.setName(super.getName()+" -> And("+value1+","+value2+")");
        setResult(value1 && value2);
    }
}
