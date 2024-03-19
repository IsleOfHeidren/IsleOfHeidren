package com.github.isleofheidren.game;

public class Combat {
    public static void main(String[] args) {
        Player player = new Player("Rogue Tiefling", 30, 16, 0, "knives");
        Monster monster = new Monster("Hydra", 50, 15, 0, "Bite");

        while (player.isAlive() && monster.isAlive()) {
            // Player's turn
            int playerAttackRoll = player.attack();
            if (playerAttackRoll >= monster.armorClass) {
                int damageDealt = player.calculateDamage();
                monster.takeDamage(damageDealt);
                System.out.println("Player hits " + monster.name + " for " + damageDealt + " damage.");
            } else {
                System.out.println("Player misses " + monster.name + ".");
            }

            // Monster's turn
            int monsterAttackRoll = monster.attack();
            if (monsterAttackRoll >= player.armorClass) {
                int damageDealt = monster.calculateDamage();
                player.takeDamage(damageDealt);
                System.out.println(monster.name + " hits Player for " + damageDealt + " damage.");
            } else {
                System.out.println(monster.name + " misses Player.");
            }

            // Print player and monster status
            System.out.println("Player HP: " + player.hitPoints);
            System.out.println("Monster HP: " + monster.hitPoints);
        }

        if (player.isAlive()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Monster wins!");
        }
    }
}
