package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Step extends Entity {
    private int numberOfStep; //Колличество уже сделанных ходов(пройденных кругов)
    private int maxValueOfSteps; //Максимальное колличество возможных ходов
    private int minValueOfSteps; //Минимальное колличество возможных ходов
    private boolean way; //Порядок хода: 1- прямой, 0 - обратный

    public Step(String name, int id) {
        super(name, id);
        this.maxValueOfSteps = 99999999;
        this.minValueOfSteps = 0;
        this.way=true;
    }

    public Step(String name, int id, int maxValueOfSteps, boolean way) {
        super(name, id);
        this.maxValueOfSteps = maxValueOfSteps;
        this.minValueOfSteps = 0;
        this.way=way;
    }

    public boolean getWay() {
        return way;
    }

    public void setWay(boolean way) {
        this.way = way;
    }

    public int getMaxValueOfSteps() {
        return maxValueOfSteps;
    }

    public void setMaxValueOfSteps(int maxValueOfSteps) {
        this.maxValueOfSteps = maxValueOfSteps;
    }

    public int getMinValueOfSteps() {
        return minValueOfSteps;
    }

    public void setMinValueOfSteps(int minValueOfSteps) {
        this.minValueOfSteps = minValueOfSteps;
    }

    public int getNumberOfStep() {
        return numberOfStep;
    }

    public void raiseNumberOfStep() {
        this.numberOfStep=this.numberOfStep+1;
    }
}
