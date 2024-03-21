package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.ApplicationAdapter;

public class MainMenuScreen implements Screen {

    final Heidren game;

    public Animation<TextureRegion> runningAnimation;

    public SpriteBatch batch;

    OrthographicCamera camera;
    Texture bg;

    ShapeRenderer border;

    Stage rootstage;
    Stage buttonStage;
    Table roottable; // table that holds all the tables
    Table buttonpanel; // also for testing since we'll be loading thing from another class
    TextButton textbutton; // test button

    private ConsoleComponent console;

    public MainMenuScreen(final Heidren game) {

        // all the inits
        this.game = game;
        rootstage = new Stage();
        buttonStage = new Stage();
        roottable = new Table();
        buttonpanel = new Table();
        console = new ConsoleComponent();

        // Heidren.font.getData().setScale(0.5f); // font scale test (broken)


        Gdx.input.setInputProcessor(rootstage);

        // int help_guide = 10; // might not need these
        // int row_height = Gdx.graphics.getHeight() /10;

        //border = new ShapeRenderer(); // add border to main screen, possibly garbage

        roottable.setFillParent(true); // everything should be added to this table
        roottable.pad(10);
        rootstage.addActor(roottable);

        buttonStage.addActor(buttonpanel); // may make lookup easier later

        buttonpanel.setSize(100,200);

        // bg = new Texture(Gdx.files.internal("sprites/bg.png")); //probably junk

        // table.setSkin(Heidren.skin); // don't remember what this is for

        roottable.setDebug(true); // shows table parameters

        // playing with simplified animation
        //runningAnimation = new Animation<TextureRegion>(0.125f, atlas.findRegions("monk"), Animation.PlayMode.LOOP);

        // test labels for blocking
        Label title = new Label("Isle of Heidren", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label space = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));

        console.appendMessage("Hello, world!", MessageType.GAME_EVENT); // Game Event Ex.
        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.


        // test panel table
        // cannot reuse buttons, gotta make em fresh
        textbutton = new TextButton("whats poppin", Heidren.skin); // test button 1
        textbutton.setName("button1"); // declare button name to easily change the button text later
        buttonpanel.add(textbutton).width(buttonpanel.getWidth()).fillY().space(5).uniform();

//        ButtonPanel panel = new ButtonPanel();
//        Table buttonPanel = panel.create("Button1", Heidren.skin, 4);
//        stage.addActor(buttonPanel);

        table1.add(button);

        table.row().expand(); //r1
        table.add(title);// r1 c1
        table.add(button); //r1 c2
        table.add(space);//r1c3

        table.row().expand();
        table.add(space);// r2 c1
        table.add(space); //r2c2
        table.add(space);//r2c3


        buttonpanel.row();
        textbutton = new TextButton("whats poppin", Heidren.skin); // test button 2
        textbutton.setName("button2"); // declare button name to easily change the button text later!!!
        textbutton.setColor(Color.WHITE);
        buttonpanel.add(textbutton).fill().space(5).uniform();

        buttonpanel.row();
        textbutton = new TextButton("whats poppin", Heidren.skin);
        textbutton.setName("button3"); // declare button name to easily change the button text later!!!
        buttonpanel.add(textbutton).fill().space(5).uniform();

        buttonpanel.row();
        textbutton = new TextButton("whats poppin", Heidren.skin);
        textbutton.setName("button4"); // declare button name to easily change the button text later!!!
        textbutton.add(space);
        buttonpanel.add(textbutton).fill().space(5).uniform(); // test blank button

        textbutton = buttonStage.getRoot().findActor("button1");
        textbutton.setText("what happens if its rally really long");


        roottable.row(); //r1 - title
        roottable.add(title).expand(); // r2 c1

        roottable.row(); //r2 - image window + stats panel
        roottable.add(space).grow().space(10);// r2 c1 image
        roottable.add(space); //r2 c2 stats

        roottable.row(); // r3 - sprites (potentially 4 cols??)
        roottable.add(space);// r3 c1
        roottable.add(space); //r3 c2
        roottable.add(space);//r3 c3

        roottable.row();
        roottable.add(console).grow().space(10); //r2c2
        roottable.add(buttonpanel).right().top().space(10);//r2c3

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
        rootstage.act(Gdx.graphics.getDeltaTime());
        rootstage.draw();

        /*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }*/
    }

    @Override
    public void resize(int width, int height) { rootstage.getViewport().update(width, height, true);}

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
    public void dispose() { rootstage.dispose(); }
}
