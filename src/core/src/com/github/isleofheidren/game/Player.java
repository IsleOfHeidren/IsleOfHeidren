package com.github.isleofheidren.game;

public class Player extends Character {
    public Player(String name, int hitPoints, int armorClass, int attackBonus, String weapon) {
        super(name, hitPoints, armorClass, attackBonus, weapon);
    }

    public void revive() {
        // Logic to revive the player
        // For example, setting hitPoints to a portion of max hit points
        hitPoints = 10; // Example value, adjust as needed
    }
}
