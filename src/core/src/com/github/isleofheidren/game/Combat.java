package com.github.isleofheidren.game;

import java.util.Scanner;

public class Combat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player rogue = new Player("Rogue Tiefling", 30, 16, 0, "Knives");
        Player wizard = new Player("Wizard Gnome", 25, 14, 0, "Staff");
        Player monk = new Player("Monk Elf", 40, 17, 0, "Staff");
        Player barbarian = new Player("Barbarian Human", 30, 17, 0, "Two-Sided Axe");

        Monster hydra = new Monster("Hydra", 50, 15, 0, new String[] { "Bite", "Fire Breath", "Multi-attack" }, 3);
        Monster crocodile = new Monster("Crocodile", 40, 16, 0, new String[] { "Bite", "Tail Whip", "Stomp" }, 1);
        Monster carnivorousApe = new Monster("Carnivorous Ape", 40, 14, 0,
                new String[] { "Fist", "Rock Throw", "Feral Bite" }, 1);

        while ((rogue.isAlive() || wizard.isAlive() || monk.isAlive() || barbarian.isAlive()) &&
                (hydra.isAlive() || crocodile.isAlive() || carnivorousApe.isAlive())) {

            // Player picks a monster to attack
            System.out.println("Choose a monster to attack (1: Hydra, 2: Crocodile, 3: Carnivorous Ape): ");
            int monsterChoice = scanner.nextInt();
            Monster targetMonster = null;
            switch (monsterChoice) {
                case 1:
                    targetMonster = hydra;
                    break;
                case 2:
                    targetMonster = crocodile;
                    break;
                case 3:
                    targetMonster = carnivorousApe;
                    break;
                }

            // Rogue's turn
            if (rogue.isAlive()) {
                System.out.println("Rogue's turn. Choose an attack (1: Sneak Attack, 2: Thieve's Cant, 3: Uncanny Dodge): ");
                int choice = scanner.nextInt();
                int damageDealt = 0;
                switch (choice) {
                    case 1:
                        damageDealt = rogue.attack("Sneak Attack");
                        break;
                    case 2:
                        damageDealt = rogue.attack("Thieve's Cant");
                        break;
                    case 3:
                        damageDealt = rogue.attack("Uncanny Dodge");
                        break;
                }
                targetMonster.takeDamage(damageDealt);
                System.out.println("Rogue hits " + targetMonster.name + " for " + damageDealt + " damage.");
            }

            // Wizard's turn
            if (wizard.isAlive()) {
                System.out.println("Wizard's turn. Choose an attack (1: Fire Bolt, 2: Poison Spray, 3: Chill Touch): ");
                int choice = scanner.nextInt();
                int damageDealt = 0;
                switch (choice) {
                    case 1:
                        damageDealt = wizard.attack("Fire Bolt");
                        break;
                    case 2:
                        damageDealt = wizard.attack("Poison Spray");
                        break;
                    case 3:
                        damageDealt = wizard.attack("Chill Touch");
                        break;
                }
                targetMonster.takeDamage(damageDealt);
                System.out.println("Rogue hits " + targetMonster.name + " for " + damageDealt + " damage.");
            }

            // Monk's turn
            if (monk.isAlive()) {
                System.out.println("Monk's turn. Choose an attack (1: Flurry of Blows, 2: Patient Defense, 3: Step of The Wind): ");
                int choice = scanner.nextInt();
                int damageDealt = 0;
                switch (choice) {
                    case 1:
                        damageDealt = monk.attack("Flurry of Blows");
                        break;
                    case 2:
                        damageDealt = monk.attack("Patient Defense");
                        break;
                    case 3:
                        damageDealt = monk.attack("Step of The Wind");
                        break;
                }
                targetMonster.takeDamage(damageDealt);
                System.out.println("Rogue hits " + targetMonster.name + " for " + damageDealt + " damage.");
            }

            // Barbarian's turn
            if (barbarian.isAlive()) {
                System.out.println("Barbarian's turn. Choose an attack (1: Reckless Attack, 2: Danger Sense, 3: Extra Attack): ");
                int choice = scanner.nextInt();
                int damageDealt = 0;
                switch (choice) {
                    case 1:
                        damageDealt = barbarian.attack("Reckless Attack");
                        break;
                    case 2:
                        damageDealt = barbarian.attack("Danger Sense");
                        break;
                    case 3:
                        damageDealt = barbarian.attack("Extra Attack");
                        break;
                }
                targetMonster.takeDamage(damageDealt);
                System.out.println("Rogue hits " + targetMonster.name + " for " + damageDealt + " damage.");
            }

            // Hydra's turn
            if (hydra.isAlive()) {
                String monsterAttack = hydra.getRandomAttack();
                int monsterDamageDealt = 0;
                switch (monsterAttack) {
                    case "Bite":
                        monsterDamageDealt = hydra.calculateDamage();
                        break;
                    case "Fire Breath":
                        monsterDamageDealt = hydra.calculateDamage();
                        break;
                    case "Multi-attack":
                        monsterDamageDealt = hydra.calculateDamage();
                        break;
                }

                if (rogue.isAlive())
                    rogue.takeDamage(monsterDamageDealt);
                if (wizard.isAlive())
                    wizard.takeDamage(monsterDamageDealt);
                if (monk.isAlive())
                    monk.takeDamage(monsterDamageDealt);
                if (barbarian.isAlive())
                    barbarian.takeDamage(monsterDamageDealt);
                System.out.println(
                        "Hydra uses " + monsterAttack + " and hits Players for " + monsterDamageDealt + " damage.");
            }

            // Crocodile's turn
            if (crocodile.isAlive()) {
                String monsterAttack = crocodile.getRandomAttack();
                int monsterDamageDealt = 0;
                switch (monsterAttack) {
                    case "Bite":
                        monsterDamageDealt = crocodile.calculateDamage();
                        break;
                    case "Tail Whip":
                        monsterDamageDealt = crocodile.calculateDamage();
                        break;
                    case "Stomp":
                        monsterDamageDealt = crocodile.calculateDamage();
                        break;
                }

                if (rogue.isAlive())
                    rogue.takeDamage(monsterDamageDealt);
                if (wizard.isAlive())
                    wizard.takeDamage(monsterDamageDealt);
                if (monk.isAlive())
                    monk.takeDamage(monsterDamageDealt);
                if (barbarian.isAlive())
                    barbarian.takeDamage(monsterDamageDealt);
                System.out.println(
                        "Crocodile uses " + monsterAttack + " and hits Players for " + monsterDamageDealt + " damage.");
            }

            // Hydra's turn
            if (carnivorousApe.isAlive()) {
                String monsterAttack = carnivorousApe.getRandomAttack();
                int monsterDamageDealt = 0;
                switch (monsterAttack) {
                    case "Fist":
                        monsterDamageDealt = carnivorousApe.calculateDamage();
                        break;
                    case "Rock Throw":
                        monsterDamageDealt = carnivorousApe.calculateDamage();
                        break;
                    case "Feral Bite":
                        monsterDamageDealt = carnivorousApe.calculateDamage();
                        break;
                }

                if (rogue.isAlive())
                    rogue.takeDamage(monsterDamageDealt);
                if (wizard.isAlive())
                    wizard.takeDamage(monsterDamageDealt);
                if (monk.isAlive())
                    monk.takeDamage(monsterDamageDealt);
                if (barbarian.isAlive())
                    barbarian.takeDamage(monsterDamageDealt);
                System.out.println("Carnivorous Ape uses " + monsterAttack + " and hits Players for "
                        + monsterDamageDealt + " damage.");
            }

            // Print player and monster status
            System.out.println("Rogue HP: " + rogue.hitPoints);
            System.out.println("Wizard HP: " + wizard.hitPoints);
            System.out.println("Monk HP: " + monk.hitPoints);
            System.out.println("Barbarian HP: " + barbarian.hitPoints);
            System.out.println("Hydra HP: " + hydra.hitPoints);
            System.out.println("Hydra HP: " + hydra.hitPoints);
            System.out.println("Crocodile HP: " + crocodile.hitPoints);
            System.out.println("Carnivorous Ape HP: " + carnivorousApe.hitPoints);
        }

        if (rogue.isAlive() || wizard.isAlive() || monk.isAlive() || barbarian.isAlive()) {
            System.out.println("Players win!");
        } else {
            System.out.println("Monster wins!");
        }

        scanner.close();
    }
}
