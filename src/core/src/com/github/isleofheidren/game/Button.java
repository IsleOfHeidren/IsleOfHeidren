package com.github.isleofheidren.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
public class Button extends Heidren {

    Stage stage;
    TextButton button;
    TextButtonStyle textButtonStyle;
    BitmapFont font;
    //Skin skin;
    //TextureAtlas buttonAtlas;

    //@Override
    public void create(String text, Skin skin) {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        //buttonAtlas = new TextureAtlas(Gdx.files.internal("skin/skin.atlas"));
        //skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        button = new TextButton(text, textButtonStyle);
        stage.addActor(button);
    }

    @Override
    public void create() {

    }

    //@Override
    public void render() {
        super.render();
        stage.draw();
    }
}