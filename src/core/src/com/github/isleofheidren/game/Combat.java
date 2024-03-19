package com.github.isleofheidren.game;

import java.util.Scanner;

public class Combat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monsterChoice;
        Monster targetMonster;

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

            if (rogue.isAlive() == true) {
                // Player picks a monster to attack
                System.out.print("Choose a monster to attack (1: Hydra, 2: Crocodile, 3: Carnivorous Ape): ");
                monsterChoice = scanner.nextInt();
                targetMonster = null;
                switch (monsterChoice) {
                    case 1:
                        targetMonster = hydra;
                        System.out.println("Hydra Chosen");
                        break;
                    case 2:
                        targetMonster = crocodile;
                        System.out.println("Crocodile Chosen");
                        break;
                    case 3:
                        targetMonster = carnivorousApe;
                        System.out.println("Carnivorous Ape Chosen");
                        break;
                }

                // Rogue's turn
                if (rogue.isAlive()) {
                    System.out.print(
                            "Rogue's turn. Choose an attack (1: Sneak Attack, 2: Thieve's Cant, 3: Uncanny Dodge): ");
                    int choice = scanner.nextInt();
                    int damageDealt = 0;
                    switch (choice) {
                        case 1:
                            damageDealt = rogue.attack("Sneak Attack");
                            System.out.println("Sneak Attack Chosen");
                            break;
                        case 2:
                            damageDealt = rogue.attack("Thieve's Cant");
                            System.out.println("Thieve's Cant Chosen");
                            break;
                        case 3:
                            damageDealt = rogue.attack("Uncanny Dodge");
                            System.out.println("Uncanny Dodge Chosen");
                            break;
                    }
                    targetMonster.takeDamage(damageDealt);
                    System.out.println("Rogue hits " + targetMonster.name + " for " + damageDealt + " damage.");
                }
            }

            if (wizard.isAlive() == true) {
                System.out.print("Choose a monster to attack (1: Hydra, 2: Crocodile, 3: Carnivorous Ape): ");
                monsterChoice = scanner.nextInt();
                targetMonster = null;
                switch (monsterChoice) {
                    case 1:
                        targetMonster = hydra;
                        System.out.println("Hydra Chosen");
                        break;
                    case 2:
                        targetMonster = crocodile;
                        System.out.println("Crocodile Chosen");
                        break;
                    case 3:
                        targetMonster = carnivorousApe;
                        System.out.println("Carnivorous Ape Chosen");
                        break;
                }

                // Wizard's turn
                if (wizard.isAlive()) {
                    System.out
                            .print("Wizard's turn. Choose an attack (1: Fire Bolt, 2: Poison Spray, 3: Chill Touch): ");
                    int choice = scanner.nextInt();
                    int damageDealt = 0;
                    switch (choice) {
                        case 1:
                            damageDealt = wizard.attack("Fire Bolt");
                            System.out.println("Fire Bolt Chosen");
                            break;
                        case 2:
                            damageDealt = wizard.attack("Poison Spray");
                            System.out.println("Poison Spray Chosen");
                            break;
                        case 3:
                            damageDealt = wizard.attack("Chill Touch");
                            System.out.println("Chill Touch Chosen");
                            break;
                    }
                    targetMonster.takeDamage(damageDealt);
                    System.out.println("Wizard hits " + targetMonster.name + " for " + damageDealt + " damage.");
                }
            }

            if (monk.isAlive() == true) {
                System.out.print("Choose a monster to attack (1: Hydra, 2: Crocodile, 3: Carnivorous Ape): ");
                monsterChoice = scanner.nextInt();
                targetMonster = null;
                switch (monsterChoice) {
                    case 1:
                        targetMonster = hydra;
                        System.out.println("Hydra Chosen");
                        break;
                    case 2:
                        targetMonster = crocodile;
                        System.out.println("Crocodile Chosen");
                        break;
                    case 3:
                        targetMonster = carnivorousApe;
                        System.out.println("Carnivorous Ape Chosen");
                        break;
                }

                // Monk's turn
                if (monk.isAlive()) {
                    System.out.print(
                            "Monk's turn. Choose an attack (1: Flurry of Blows, 2: Patient Defense, 3: Step of The Wind): ");
                    int choice = scanner.nextInt();
                    int damageDealt = 0;
                    switch (choice) {
                        case 1:
                            damageDealt = monk.attack("Flurry of Blows");
                            System.out.println("Flurry of Blows Chosen");
                            break;
                        case 2:
                            damageDealt = monk.attack("Patient Defense");
                            System.out.println("Patient Defense Chosen");
                            break;
                        case 3:
                            damageDealt = monk.attack("Step of The Wind");
                            System.out.println("Step of The Wind Chosen");
                            break;
                    }
                    targetMonster.takeDamage(damageDealt);
                    System.out.println("Monk hits " + targetMonster.name + " for " + damageDealt + " damage.");
                }
            }

            if (barbarian.isAlive() == true) {
                System.out.print("Choose a monster to attack (1: Hydra, 2: Crocodile, 3: Carnivorous Ape): ");
                monsterChoice = scanner.nextInt();
                targetMonster = null;
                switch (monsterChoice) {
                    case 1:
                        targetMonster = hydra;
                        System.out.println("Hydra Chosen");
                        break;
                    case 2:
                        targetMonster = crocodile;
                        System.out.println("Crocodile Chosen");
                        break;
                    case 3:
                        targetMonster = carnivorousApe;
                        System.out.println("Carnivorous Ape Chosen");
                        break;
                }

                // Barbarian's turn
                if (barbarian.isAlive()) {
                    System.out.print(
                            "Barbarian's turn. Choose an attack (1: Reckless Attack, 2: Danger Sense, 3: Extra Attack): ");
                    int choice = scanner.nextInt();
                    int damageDealt = 0;
                    switch (choice) {
                        case 1:
                            damageDealt = barbarian.attack("Reckless Attack");
                            System.out.println("Reckless Attack Chosen");
                            break;
                        case 2:
                            damageDealt = barbarian.attack("Danger Sense");
                            System.out.println("Danger Sense Chosen");
                            break;
                        case 3:
                            damageDealt = barbarian.attack("Extra Attack");
                            System.out.println("Extra Attack Chosen");
                            break;
                    }
                    targetMonster.takeDamage(damageDealt);
                    System.out.println("Barbarian hits " + targetMonster.name + " for " + damageDealt + " damage.");
                }
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
            if (rogue.isAlive() == false) {
                System.out.println("Rogue Defeated");
            }
            System.out.println("Wizard HP: " + wizard.hitPoints);
            if (wizard.isAlive() == false) {
                System.out.println("Wizard Defeated");
            }
            System.out.println("Monk HP: " + monk.hitPoints);
            if (monk.isAlive() == false) {
                System.out.println("Monk Defeated");
            }
            System.out.println("Barbarian HP: " + barbarian.hitPoints);
            if (barbarian.isAlive() == false) {
                System.out.println("Barbarian Defeated");
            }
            System.out.println("Hydra HP: " + hydra.hitPoints);
            if (hydra.isAlive() == false) {
                System.out.println("Hyrda Defeated");
            }
            System.out.println("Crocodile HP: " + crocodile.hitPoints);
            if (crocodile.isAlive() == false) {
                System.out.println("Crocodile Defeated");
            }
            System.out.println("Carnivorous Ape HP: " + carnivorousApe.hitPoints);
            if (carnivorousApe.isAlive() == false) {
                System.out.println("Carnivorous Ape Defeated");
            }
        }

        if (rogue.isAlive() || wizard.isAlive() || monk.isAlive() || barbarian.isAlive()) {
            System.out.println("Players win!");
        } else {
            System.out.println("Monsters wins!");
        }

        scanner.close();
    }
}
