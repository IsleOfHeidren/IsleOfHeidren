package com.github.isleofheidren.game.models;

import java.util.Random;

public class Character {
    private String name;
    private int hitPoints;
    private int armorClass;
    private int attackBonus;
    private String weapon;
    private String statusEffect;

    public Character(String name, int hitPoints, int armorClass, int attackBonus, String weapon) {
        this.setName(name);
        this.setHitPoints(hitPoints);
        this.setArmorClass(armorClass);
        this.setAttackBonus(attackBonus);
        this.setWeapon(weapon);
    }

    public Character() {};

    public boolean isAlive() {
        return getHitPoints() > 0;
    }

    public int rollDice(int sides) {
        Random random = new Random();
        return random.nextInt(sides) + 1;
    }

    public int tryAttack() {
        return rollDice(20) + getAttackBonus();
    }

    public int attack(String chosenAttack) {
        int damageDealt = 0;
        switch (chosenAttack) {
            case "Sneak Attack":
                damageDealt = rollDice(8) + getAttackBonus();
                break;
            case "Thieve's Cant":
                damageDealt = rollDice(6) + getAttackBonus();
                break;
            case "Uncanny Dodge":
                // Implement uncanny dodge if it affects the attack
                break;
            case "Fire Bolt":
                damageDealt = rollDice(10) + getAttackBonus();
                break;
            case "Poison Spray":
                damageDealt = rollDice(8) + getAttackBonus();
                break;
            case "Chill Touch":
                damageDealt = rollDice(6) + getAttackBonus();
                break;
            case "Flurry of Blows":
                damageDealt = (rollDice(4) * 3) + getAttackBonus();
                break;
            case "Patient Defense":
                setArmorClass(getArmorClass() + rollDice(8));
                break;
            case "Step of The Wind":
                damageDealt = rollDice(2) + getAttackBonus();
                break;
            case "Reckless Attack":
                damageDealt = rollDice(12) + getAttackBonus();
                break;
            case "Danger Sense":
                setArmorClass(getArmorClass() + rollDice(8));
                break;
            case "Extra Attack":
                damageDealt = (rollDice(6) * 2) + getAttackBonus();
                break;
        }
        return damageDealt;
    }

    public int calculateDamage(int diceSides) {
        // Calculate damage based on the weapon and dice sides
        int damage = rollDice(diceSides);
        if (getWeapon() != null && getWeapon().equals("Knives")) {
            damage += rollDice(4); // 1d4 bonus damage for Knives
        } else if (getWeapon() != null && getWeapon().equals("Staff")) {
            damage += rollDice(6); // 1d6 bonus damage for Staff
        } else if (getWeapon() != null && getWeapon().equals("Two-Sided Axe")) {
            damage += rollDice(8); // 1d8 bonus damage for Two-Sided Axe
        }
        return damage;
    }

    public void takeDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
        if (getHitPoints() < 0)
            setHitPoints(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(String statusEffect) {
        this.statusEffect = statusEffect;
    }
}
