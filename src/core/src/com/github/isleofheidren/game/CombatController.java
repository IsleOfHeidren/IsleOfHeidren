package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.github.isleofheidren.game.models.*;
import com.github.isleofheidren.game.models.Character;
import com.github.isleofheidren.game.repos.MonsterRepo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CombatController {
    private final ConsoleComponent console;
    private final StatPanel panel;
    private int turn = 0;
    private boolean inCombat = false;
    List<Monster> monsters;
    List<PlayerCharacter> players;
    List<Character> combatOrder;
    private boolean lastCombatVictory = false;
    private PlayerCharacter currentPlayer;

    CombatController(Button[] buttons, ConsoleComponent console, StatPanel panel) {
        this.console = console;
        this.panel = panel;
    }

    public void StartCombat(CombatEvent event, PlayerCharacter[] players) {
        turn = 0;
        inCombat = true;
        monsters = new ArrayList<>();
        this.players = new ArrayList<>();
        combatOrder = new ArrayList<>();

        this.players.addAll(Arrays.asList(players));

        //Load in the required monsters
        MonsterRepo repo = new MonsterRepo();
        for (int i = 0; i < event.getMonsters().length; i++) {
            String monsterName = event.getMonsters()[i];
            Monster monster = repo.get(monsterName);

            this.monsters.add(monster);
        }

//        for (int i = 0; i < buttons.length; i++) {
//            buttons[0].addListener(new ClickListener() {
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                    handleButtonClick(event);
//                }
//            });
//        }

        //Create the order that combat will occur in
        createCombatOrder();
    }

    /*
    Returns a boolean for if the state manager is in combat currently
     */
    public boolean isInCombat() {
        return inCombat;
    }

//    private void handleButtonClick(InputEvent event)
//
//    }

    private void createCombatOrder() {
        Random r1 = new Random(System.currentTimeMillis());
        int allCount = monsters.size() + players.size();

        while (allCount > 0)
        {
            int order = ThreadLocalRandom.current().nextInt(0, monsters.size() + players.size());
            Character next;
            if (order > players.size() - 1) {
                next = monsters.get(order - players.size());
            }
            else {
                next = players.get(order);
            }

            if (!combatOrder.contains(next)) {
                combatOrder.add(next);
                allCount--;
            }
        }

        //This insures that we always end up returning control to the UI with a player character turn active
        while (combatOrder.get(getTurn()) instanceof Monster) {
            incrementTurn();
        }
    }

    public void doNextTurn(Action action) {
//        if (!anyPlayerAlive()) {
//            lastCombatVictory = false;
//            return;
//        }
//
//        if (!anyMonsterAlive()) {
//            lastCombatVictory = true;
//            return;
//        }

        //Do combat stuff for this turn
        int damage = action.getCharacter().attack(action.getMove().getName());
        int hit = action.getCharacter().tryAttack();
        Monster attackTarget = getRandomAliveMonster();
        String message = action.getCharacter().getName() + " attacks " + attackTarget.getName() + " with " + action.getMove().getName();
        console.appendMessage(message, MessageType.COMBAT_RESULT);

        //If the attack hits update monster health and display
        if (hit >= attackTarget.getArmorClass()) {
            attackTarget.takeDamage(damage);
            message = "it hits for " + damage + " damage";
        }
        else {
            message = "it misses";
        }

        console.appendMessage(message, MessageType.COMBAT_RESULT);

        message = attackTarget.getName() + " has " + attackTarget.getHitPoints() + " remaining!";
        console.appendMessage(message, MessageType.COMBAT_RESULT);

        if (!anyMonsterAlive()) {
            lastCombatVictory = true;
            console.appendMessage("Combat Victory", MessageType.COMBAT_RESULT);
            inCombat = false;
            return;
        }

        incrementTurn();

        //Do the monster moves
        while (combatOrder.get(getTurn()) instanceof Monster) {

            PlayerCharacter targetPlayer = getRandomAlivePlayer();

            Monster monster = (Monster) combatOrder.get(getTurn()) ;
            hit = monster.tryAttack();
            String monsterAttack = monster.getRandomAttack();
            damage = monster.calculateDamage(monsterAttack);

            message = monster.getName() + " attacks " + targetPlayer.getName() + " with " + monsterAttack;
            console.appendMessage(message, MessageType.COMBAT_RESULT);

            if (hit >= targetPlayer.getArmorClass()) {
                targetPlayer.takeDamage(damage);
                message = "it hits for " + damage + " damage";
            }
            else {
                message = "it misses";
            }

            console.appendMessage(message, MessageType.COMBAT_RESULT);

            if(!anyPlayerAlive())
            {
                lastCombatVictory = false;
                console.appendMessage("Combat Lost", MessageType.COMBAT_RESULT);
                inCombat = false;
                return;
            }

            incrementTurn();
        }

        //update the stat panel
        panel.addCharacterToPanel(getCurrentPlayer());
    }

    private void incrementTurn() {
        if (getTurn() == combatOrder.size() - 1) {
            turn = 0;
        }
        else {
            turn = getTurn() + 1;
        }
    }

    private Monster getRandomAliveMonster() {
        while (true) {
            Monster monster = monsters.get(ThreadLocalRandom.current().nextInt(0, monsters.size()));
            if (monster.isAlive()) {
                return monster;
            }
        }
    }

    private PlayerCharacter getRandomAlivePlayer() {
        while (true) {
            PlayerCharacter player = players.get(ThreadLocalRandom.current().nextInt(0, players.size()));
            if (player.isAlive()) {
                return player;
            }
        }
    }

    /*
    Returns if any monsters are alive
     */
    private boolean anyMonsterAlive() {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).isAlive()) {
                return true;
            }
        }

        return false;
    }

    /*
    Returns if any player in the combat is still alive
     */
    private boolean anyPlayerAlive() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isAlive()) {
                return true;
            }
        }

        return false;
    }

    public boolean isLastCombatVictory() {
        return lastCombatVictory;
    }

    public PlayerCharacter getCurrentPlayer() {
        return (PlayerCharacter) combatOrder.get(getTurn());
    }

    private int getTurn() {
        return turn;
    }
}
