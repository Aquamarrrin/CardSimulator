package ru.cardsim.app.entities;

import java.util.ArrayList;

/**
 * Created by bombaster on 12.02.2016.
 */
public class Property<T> {

    private String name;
    private T value;

    public Property(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
