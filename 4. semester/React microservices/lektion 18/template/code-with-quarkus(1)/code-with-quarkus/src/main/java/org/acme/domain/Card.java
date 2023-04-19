package org.acme.domain;

public abstract class Card {
    private int ID;
    private int height;
    private int width;
    private String name;
    private String description;

    public  Card (int ID, String name, int height, int width, String description ) {
        this.ID = ID;
        this.name = name;
        this.height = height;
        this.width = width;
        this.description = description;


    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDescription() {
        return description;
    }
}
