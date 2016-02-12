package ru.cardsim.app.rules.logicoperators;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Not extends LogicOperator {

    public Not(boolean value) {
        setResult(!value);
    }

}
