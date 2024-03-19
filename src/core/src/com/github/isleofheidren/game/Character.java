package com.github.isleofheidren.game;

import java.util.Random;

public class Character {
    protected String name;
    protected int hitPoints;
    protected int armorClass;
    protected int attackBonus;
    protected String weapon;

    public Character(String name, int hitPoints, int armorClass, int attackBonus, String weapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.attackBonus = attackBonus;
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public int rollDice(int sides) {
        Random random = new Random();
        return random.nextInt(sides) + 1;
    }

    public int attack() {
        // Roll a 20-sided dice and add attack bonus
        return rollDice(20) + attackBonus;
    }

    public int calculateDamage() {
        // Calculate damage based on the weapon
        // You can extend this method to include weapon-specific damage calculations
        return rollDice(6); // Default damage roll (1d6)
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0)
            hitPoints = 0;
    }
}
