package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.github.isleofheidren.game.models.PlayerCharacter;

public class StatPanel extends Table {
    public StatPanel() {
        super();
    }

    public StatPanel(PlayerCharacter character) {
        super();

        addCharacterToPanel(character);
    }

    public void addCharacterToPanel(PlayerCharacter playerCharacter) {
        clear();

        columnDefaults(1).width(50);
        add(new Label("Current Character", Heidren.skin)).colspan(2);
        row();

        add(new Label("Name:", Heidren.skin)).left();
        add(new Label(playerCharacter.getName(), Heidren.skin)).left();
        row();


        add(new Label("HP:", Heidren.skin)).left();
        String hp = Integer.toString(playerCharacter.getHitPoints());
        add(new Label(hp, Heidren.skin)).left();
        row();
    }
}
