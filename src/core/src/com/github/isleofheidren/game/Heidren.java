// "driver"
package com.github.isleofheidren.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Heidren extends Game {
	public SpriteBatch batch;
	public BitmapFont font;



	public void create () {


		batch = new SpriteBatch();

		font = new BitmapFont();

		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}