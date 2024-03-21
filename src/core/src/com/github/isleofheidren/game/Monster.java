package com.github.isleofheidren.game;

import java.util.Random;

public class Monster extends Character {
    private String[] attacks;
    private int numHeads;

    public Monster(String name, int hitPoints, int armorClass, int attackBonus, String[] attacks, int numHeads) {
        super(name, hitPoints, armorClass, attackBonus, null);
        this.attacks = attacks;
        this.numHeads = numHeads;
    }

    public String getRandomAttack() {
        Random random = new Random();
        int index = random.nextInt(attacks.length);
        return attacks[index];
    }

    public int attack() {
        // Roll a 20-sided dice and add attack bonus
        return rollDice(20) + attackBonus;
    }

    public int calculateDamage() {
        String chosenAttack = getRandomAttack();
        int damage = 0;
        switch (chosenAttack) {
            case "Bite":
                damage = (rollDice(10) + 5);
                break;
            case "Fire Breath":
                damage = (rollDice(12) + 5);
                break;
            case "Multi-attack":
                damage = (rollDice(8) + 2) * numHeads;
                break;
            case "Tail Whip":
                damage = (rollDice(8) + 1);
                break;
            case "Stomp":
                damage = (rollDice(6) + 1);
                break;
            case "Fist":
                damage = (rollDice(6) + 3);
                break;
            case "Rock Throw":
                damage = (rollDice(6) + 3);
                break;
            case "Feral Bite":
                damage = (rollDice(10) + 4);
        }
        return damage;
    }
}
