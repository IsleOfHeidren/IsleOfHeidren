package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.isleofheidren.game.models.Character;
import com.github.isleofheidren.game.models.CombatEvent;
import com.github.isleofheidren.game.models.Monster;
import com.github.isleofheidren.game.models.PlayerCharacter;
import com.github.isleofheidren.game.repos.MonsterRepo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CombatController {
    private final Button[] buttons;
    private final ConsoleComponent console;
    int turn = 0;
    private boolean inCombat = false;
    List<Monster> monsters;
    List<PlayerCharacter> players;
    List<Character> combatOrder;

    CombatController(Button[] buttons, ConsoleComponent console, StatPanel statPanel) {

        this.buttons = buttons;
        this.console = console;
    }

    public void StartCombat(CombatEvent event, PlayerCharacter[] players) {
        turn = 0;
        inCombat = true;
        monsters = new ArrayList<>();
        this.players = new ArrayList<>();
        combatOrder = new ArrayList<>();

        this.players.addAll(Arrays.asList(players));

        MonsterRepo repo = new MonsterRepo();
        for (int i = 0; i < event.getMonsters().length; i++) {
            String monsterName = event.getMonsters()[i];
            Monster monster = repo.get(monsterName);

            this.monsters.add(monster);
        }

        for (int i = 0; i < buttons.length; i++) {
            buttons[0].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    handleButtonClick(event);
                }
            });
        }

        combatOrder();
    }

    public boolean isInCombat() {
        return inCombat;
    }

    private void handleButtonClick(InputEvent event)

    }

    private void combatOrder() {
        Random r1 = new Random(System.currentTimeMillis());
        int allCount = monsters.size() + players.size();

        int order = ThreadLocalRandom.current().nextInt(0, 10);

        if (order > players.size() - 1) {

        }
        else {

        }
    }
}
