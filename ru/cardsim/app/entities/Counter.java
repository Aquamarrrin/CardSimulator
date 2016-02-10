package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Counter extends Entity {
    private int maxValue; //Максимальное значение счетчика
    private int minValue; //Минимальное значение счетчика
    private int startValue; //Начальное значение счетчика
    private int endValue; //Конечное значение счетчика
    private int stepValue; //Шаг счетчика
    private int curentValue; //Текущее значение счетчика

    public Counter(String name, int id) {
        super(name, id);
        this.maxValue=0;
        this.minValue=0;
        this.startValue=0;
        this.endValue=0;
        this.stepValue=0;
        this.curentValue = startValue;
    }

    public Counter(String name, int id, int startValue, int endValue, int stepValue) {
        super(name, id);
        this.startValue = startValue;
        this.endValue = endValue;
        this.stepValue = stepValue;
        this.curentValue = startValue;
    }

    public Counter(String name, int id, int maxValue, int minValue, int startValue, int endValue, int stepValue) {
        super(name, id);
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.startValue = startValue;
        this.endValue = endValue;
        this.stepValue = stepValue;
        this.curentValue = startValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public int getStepValue() {
        return stepValue;
    }

    public void setStepValue(int stepValue) {
        this.stepValue = stepValue;
    }

    public int getCurentValue() {
        return curentValue;
    }

    public void setCurentValue(int curentValue) {
        this.curentValue = curentValue;
    }

    public void raiseValue() {
        this.curentValue = this.curentValue+this.stepValue;
    }
}
