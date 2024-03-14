package com.github.isleofheidren.game.models;

/*
Model for combat event, includes all properties necessary for combat to happen
 */
public class CombatEvent extends Event{
    private PlayerCharacter currentCharacter;
    private PlayerCharacter[] otherCharacters;
    private Monster[] monsters;

    public PlayerCharacter getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(PlayerCharacter currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    public PlayerCharacter[] getOtherCharacters() {
        return otherCharacters;
    }

    public void setOtherCharacters(PlayerCharacter[] otherCharacters) {
        this.otherCharacters = otherCharacters;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }
}
