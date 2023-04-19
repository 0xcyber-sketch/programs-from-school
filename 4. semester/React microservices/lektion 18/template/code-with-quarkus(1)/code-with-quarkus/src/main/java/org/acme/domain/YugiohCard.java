package org.acme.domain;

public class YugiohCard extends Card{

    private int attackPoints;
    private int defensePoints;


    public YugiohCard(int ID, String name, int height, int width, String description, int attackPoints, int defensePoints) {
        super(ID, name, height, width, description);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
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

    public int getAttackPoints() {
        return attackPoints;
    }


    public int getDefensePoints() {
        return defensePoints;
    }
}
