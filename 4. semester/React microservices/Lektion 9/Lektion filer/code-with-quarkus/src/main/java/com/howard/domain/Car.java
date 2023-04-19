package com.howard.domain;

public class Car {
    private final String type;
    private final String name;

    public Car(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
