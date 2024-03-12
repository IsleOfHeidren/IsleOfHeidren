// "driver"
package com.github.isleofheidren.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.github.isleofheidren.game.MessageType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Heidren extends Game {
    private Stage stage;
	public SpriteBatch batch;
    private ConsoleComponent console;

    @Override
    public void create() {
		batch = new SpriteBatch();
        stage = new Stage(new FitViewport(800, 600));
        Gdx.input.setInputProcessor(stage);

        console = new ConsoleComponent();
        stage.addActor(console);

        // Example
        console.appendMessage("Hello, world!", MessageType.GAME_EVENT); // Game Event Ex.
        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.
    }

    @Override
    public void render() {
        super.render();
        stage.act(Gdx.graphics.getDeltaTime()); // returns time passed between last and current frame in seconds
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
