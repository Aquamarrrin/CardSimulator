package ru.cardsim.app.entities;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Play extends Entity {
    private boolean pause;
    private int duration;
    private Counter counter;

    public Play(String name, int id) {
        super(name, id);
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
