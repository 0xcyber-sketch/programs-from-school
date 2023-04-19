package org.acme.domain;

public class PokemonCard extends Card{
    private String elementType;
    private boolean EX;
    private int powerPoints;


    public PokemonCard(int ID, String name, int height, int width, String description, String elementType, boolean ex, int powerPoints) {
        super(ID, name, height, width, description);
        this.elementType = elementType;
        this.EX = ex;
        this.powerPoints = powerPoints;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    public String getElementType() {
        return elementType;
    }

    public boolean isEX() {
        return EX;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public String toString() {
        return getName();
    }
}
