package com.projects.car.domain;

public class Car {
    private String name;
    private String model;

    public Car (){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
    }
}
