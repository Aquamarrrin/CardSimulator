package ru.cardsim.app.entities;

import java.util.HashMap;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Entity {
    private String name;
    private int id;
    private HashMap<Integer, Property> properties;

    public Entity() {
    }

    public Entity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //addEntity

    //setEntity(nameProperty, newValue)
    //getEntity(nameProperty)
}
