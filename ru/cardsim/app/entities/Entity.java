package ru.cardsim.app.entities;

import java.util.HashMap;

/**
 * Created by bombaster on 09.02.2016.
 */
public class Entity {
    private String name;
    private int id;
    private int countOfProperties;
    private HashMap<Integer, Property> properties;
    private HashMap<String, Integer> namesAndIDsOfProperties;

    public Entity() {
    }

    public Entity(String name, int id) {
        properties = new HashMap<>();
        namesAndIDsOfProperties = new HashMap<>();
        this.name = name;
        this.id = id;
        this.countOfProperties = 0;
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

    //Добавляет свойство в карту свойств для данной сущности
    public void addProperty(String nameOfProperty, Object value){
        countOfProperties=countOfProperties+1;
        Property<Object> newProperty = new Property<>(nameOfProperty,value);
        properties.put(countOfProperties,newProperty);
        namesAndIDsOfProperties.put(nameOfProperty,countOfProperties);
    }

    //Задаём новое значение свойству
    public void setProperty(String nameOfProperty, Object value){
        try{
           Property<Object> newProperty = new Property<>(nameOfProperty,value);
           properties.put(namesAndIDsOfProperties.get(nameOfProperty),newProperty);
        } catch (Exception e){
            System.out.println("Такого свойства не существует!");
        }
    }

    //Возвращает значение свойства
    public Object getProperty(String nameOfProperty){
        try{
            return properties.get(namesAndIDsOfProperties.get(nameOfProperty)).getValue();
        } catch (Exception e){
            System.out.println("Такого свойства не существует!");
            return null;
        }
    }
}
