// "driver"
package com.github.isleofheidren.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Heidren extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public static Skin skin;

    @Override
    public void create() {
		batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("skin/skin.json"));

        this.setScreen(new StartScreen(this)); // DO NOT DELETE
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
