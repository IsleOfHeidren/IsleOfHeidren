package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

public class MainMenuScreen implements Screen {

    final Heidren game;

    public Animation<TextureRegion> runningAnimation;

    public SpriteBatch batch;

    OrthographicCamera camera;
    Texture bg;

    ShapeRenderer border;

    Stage stage;
    Table roottable; // table that holds all the tables
    Table buttonpanel; // also for testing since we'll be loading thing from another class
    Button button; // test button

    private ConsoleComponent console;

    public MainMenuScreen(final Heidren game) {

        // all the inits
        this.game = game;
        stage = new Stage();
        roottable = new Table();
        buttonpanel = new Table();
        console = new ConsoleComponent();

        Gdx.input.setInputProcessor(stage);

        // int help_guide = 10; // might not need these
        // int row_height = Gdx.graphics.getHeight() /10;

        //border = new ShapeRenderer(); // add border to main screen, possibly garbage

        roottable.setFillParent(true); // everything should be added to this table
        stage.addActor(roottable);

        // bg = new Texture(Gdx.files.internal("sprites/bg.png")); //probably junk

        // table.setSkin(Heidren.skin); // don't remembre what this is for

        button = new Button(Heidren.skin); // test button
        button.add("whats poppin");

        roottable.setDebug(true); // shows table parameters

        // playing with simplified animation
        //runningAnimation = new Animation<TextureRegion>(0.125f, atlas.findRegions("monk"), Animation.PlayMode.LOOP);

        // test labels for blocking
        Label title = new Label("this is the next screen", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label space = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));

        console.appendMessage("Hello, world!", MessageType.GAME_EVENT); // Game Event Ex.
        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.

        // test panel table
        buttonpanel.add(button);
        buttonpanel.row();
        buttonpanel.add(button);
        buttonpanel.row();
        buttonpanel.add(button);
        buttonpanel.row();
        buttonpanel.add(button);

        roottable.row().expand(); //r1
        roottable.add(title); // r1 c1

        roottable.row().expand(); //r2
        roottable.add(space);// r2 c1
        roottable.add(space); //r2 c2
        roottable.add(space);//r1c3

        roottable.row();
        roottable.add(space);// r2 c1
        roottable.add(console).expand(); //r2c2
        roottable.add(buttonpanel);//r2c3

        roottable.row().expand();
        roottable.add(space);// r3 c1
        roottable.add(space); //r3c2
        roottable.add(space);//r3c3

        camera = new OrthographicCamera();
        camera.setToOrtho(false,1000,600);

    }

    @Override
    public void show() {

    }

    @Override
    public void render (float delta){

        ScreenUtils.clear(0,0,0,1);
        camera.update();

        // game.batch.begin(); // forget what these are for
        // game.batch.end();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        /*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }*/
    }

    @Override
    public void resize(int width, int height) { stage.getViewport().update(width, height, true);}

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() { stage.dispose(); }
}
