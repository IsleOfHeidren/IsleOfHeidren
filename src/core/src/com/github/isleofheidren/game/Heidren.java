// "driver"
package com.github.isleofheidren.game;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ec4095b3c72d4eda74166cbddeb52731dfb00d04
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
<<<<<<< HEAD
=======
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
>>>>>>> origin/main
=======
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
>>>>>>> ec4095b3c72d4eda74166cbddeb52731dfb00d04

public class Heidren extends Game {
    private Stage stage;
	public SpriteBatch batch;
<<<<<<< HEAD
<<<<<<< HEAD
    private ConsoleComponent console;
=======
	public BitmapFont font;
	public static Skin skin;


	public void create () {
		skin = new Skin(Gdx.files.internal("skin/skin.json"));
>>>>>>> origin/main

=======
    private ConsoleComponent console;
	public BitmapFont font;
	public static Skin skin;

>>>>>>> ec4095b3c72d4eda74166cbddeb52731dfb00d04
    @Override
    public void create() {
		batch = new SpriteBatch();
        stage = new Stage(new FitViewport(800, 600));
        skin = new Skin(Gdx.files.internal("skin/skin.json"));

        Gdx.input.setInputProcessor(stage);

        console = new ConsoleComponent();
        stage.addActor(console);

<<<<<<< HEAD
        // Example
        console.appendMessage("Hello, world!", MessageType.GAME_EVENT); // Game Event Ex.
        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.
    }
=======
		this.setScreen(new StartScreen(this));
	}
>>>>>>> origin/main

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
