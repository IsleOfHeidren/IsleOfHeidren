package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.isleofheidren.game.models.Event;

public class ButtonPanel extends Heidren {
    TextButton button;
    TextButtonStyle textButtonStyle;
    BitmapFont font;

    //@Override
    public Table createStoryPanel(Event event) {
        font = new BitmapFont();
        Table panel = new Table();
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        for(int i = 0; i < 4; i++) {
            button = new TextButton("Button", textButtonStyle);
            panel.add(button);
        }

        return panel;
    }

    public Table createCombatPanel(Player current) {
        font = new BitmapFont();
        Table panel = new Table();
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        for(int i = 0; i < 4; i++) {
            button = new TextButton("Button", textButtonStyle);
            panel.add(button);
        }

        return panel;
    }
}