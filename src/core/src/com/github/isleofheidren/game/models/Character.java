package com.github.isleofheidren.game.models;

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

    public int attack(String chosenAttack) {
        int damageDealt = 0;
        switch (chosenAttack) {
            case "Sneak Attack":
                damageDealt = rollDice(8) + attackBonus;
                break;
            case "Thieve's Cant":
                damageDealt = rollDice(6) + attackBonus;
                break;
            case "Uncanny Dodge":
                // Implement uncanny dodge if it affects the attack
                break;
            case "Fire Bolt":
                damageDealt = rollDice(10) + attackBonus;
                break;
            case "Poison Spray":
                damageDealt = rollDice(8) + attackBonus;
                break;
            case "Chill Touch":
                damageDealt = rollDice(6) + attackBonus;
                break;
            case "Flurry of Blows":
                damageDealt = (rollDice(4) * 3) + attackBonus;
                break;
            case "Patient Defense":
                armorClass += rollDice(8);
                break;
            case "Step of The Wind":
                damageDealt = rollDice(2) + attackBonus;
                break;
            case "Reckless Attack":
                damageDealt = rollDice(12) + attackBonus;
                break;
            case "Danger Sense":
                armorClass += rollDice(8);
                break;
            case "Extra Attack":
                damageDealt = (rollDice(6) * 2) + attackBonus;
                break;
        }
        return damageDealt;
    }

    public int calculateDamage(int diceSides) {
        // Calculate damage based on the weapon and dice sides
        int damage = rollDice(diceSides);
        if (weapon != null && weapon.equals("Knives")) {
            damage += rollDice(4); // 1d4 bonus damage for Knives
        } else if (weapon != null && weapon.equals("Staff")) {
            damage += rollDice(6); // 1d6 bonus damage for Staff
        } else if (weapon != null && weapon.equals("Two-Sided Axe")) {
            damage += rollDice(8); // 1d8 bonus damage for Two-Sided Axe
        }
        return damage;
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0)
            hitPoints = 0;
    }
}
