package com.github.isleofheidren.game.models;

public class Feature {
    private boolean isCombat;
    private int damage;
    private String name;

    public boolean isCombat() {
        return isCombat;
    }

    public void setCombat(boolean combat) {
        isCombat = combat;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
