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
    private int id;

    public Rule(Condition condition, Method method1, Method method2) {
        /*
        //Делаем конвеер создания кондишенов
        boolean result = new Condition(new And(new Or(new Equals("str", "str").getResult(), new Equals("str", "str").getResult()).getResult(), new Not(new Equals(1, 1).getResult()).getResult())).getResult();
        //Привязываем к првилу метод в результате тру или фолса

        System.out.println("RESULT: "+result);
        */
        this.condition=condition;
        this.method1=method1;
        this.method2=method2;
        this.id  = 0;
    }

    public Rule(Condition condition, Method method1) {
        /*
        //Делаем конвеер создания кондишенов
        boolean result = new Condition(new And(new Or(new Equals("str", "str").getResult(), new Equals("str", "str").getResult()).getResult(), new Not(new Equals(1, 1).getResult()).getResult())).getResult();
        //Привязываем к првилу метод в результате тру или фолса

        System.out.println("RESULT: "+result);
        */

        this.condition=condition;
        this.method1=method1;
        this.id  = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Method getMethod1() {
        return method1;
    }

    public void setMethod1(Method method1) {
        this.method1 = method1;
    }

    public Method getMethod2() {
        return method2;
    }

    public void setMethod2(Method method2) {
        this.method2 = method2;
    }
}
