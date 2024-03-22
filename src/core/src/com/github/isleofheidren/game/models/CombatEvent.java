package com.github.isleofheidren.game.models;

/*
Model for combat event, includes all properties necessary for combat to happen
 */
public class CombatEvent extends Event{
    private String currentCharacter;
    private String[] otherCharacters;
    private String[] monsters;

    public String getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(String currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    public String[] getOtherCharacters() {
        return otherCharacters;
    }

    public void setOtherCharacters(String[] otherCharacters) {
        this.otherCharacters = otherCharacters;
    }

    public String[] getMonsters() {
        return monsters;
    }

    public void setMonsters(String[] monsters) {
        this.monsters = monsters;
    }
}
