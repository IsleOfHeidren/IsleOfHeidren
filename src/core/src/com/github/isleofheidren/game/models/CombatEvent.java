package com.github.isleofheidren.game.models;

/*
Model for combat event, includes all properties necessary for combat to happen
 */
public class CombatEvent extends Event{
    private String[] monsters;

    public String[] getMonsters() {
        return monsters;
    }

    public void setMonsters(String[] monsters) {
        this.monsters = monsters;
    }
}
