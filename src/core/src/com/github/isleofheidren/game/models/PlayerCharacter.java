package com.github.isleofheidren.game.models;

public class PlayerCharacter {
    private String name;
    private Feature[] features;
    private int armorClass;

    public PlayerCharacter() {

    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
