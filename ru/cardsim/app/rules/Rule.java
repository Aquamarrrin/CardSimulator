package ru.cardsim.app.rules;

import ru.cardsim.app.rules.expressions.Equals;
import ru.cardsim.app.rules.logicoperators.And;
import ru.cardsim.app.rules.logicoperators.Not;
import ru.cardsim.app.rules.logicoperators.Or;

import java.lang.reflect.Method;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Rule {

    private Condition condition;
    private Method method1;
    private Method method2;
    public Rule(Condition condition, Method method1, Method method2) {
        /*
        //Делаем конвеер создания кондишенов
        boolean result = new Condition(new And(new Or(new Equals("str", "str").getResult(), new Equals("str", "str").getResult()).getResult(), new Not(new Equals(1, 1).getResult()).getResult())).getResult();
        //Привязываем к првилу метод в результате тру или фолса

        System.out.println("RESULT: "+result);
        */
    }

    public Rule(Condition condition, Method method1) {
        /*
        //Делаем конвеер создания кондишенов
        boolean result = new Condition(new And(new Or(new Equals("str", "str").getResult(), new Equals("str", "str").getResult()).getResult(), new Not(new Equals(1, 1).getResult()).getResult())).getResult();
        //Привязываем к првилу метод в результате тру или фолса

        System.out.println("RESULT: "+result);
        */
    }


}
