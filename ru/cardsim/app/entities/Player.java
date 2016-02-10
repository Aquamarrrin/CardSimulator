package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Player extends Entity {
    private Counter counter;
    private boolean hisTurn; //1- если очередь игрока ходить, 0- если не его
    private boolean leader; //1- если игрок лидирует, 0- если нет
/*У игрока должен быть вектор доступных действий,
но я пока не знаю, как это реализовать.
 */
    public Player(String name, int id) {
        super(name, id);
    }

    public boolean isHisTurn() {
        return hisTurn;
    }

    public void setHisTurn(boolean hisTurn) {
        this.hisTurn = hisTurn;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
}
