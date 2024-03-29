package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.ApplicationAdapter;
import com.github.isleofheidren.game.models.PlayerCharacter;
import com.github.isleofheidren.game.repos.PlayerCharacterRepo;

import java.util.ArrayList;
import java.util.List;


public class MainMenuScreen implements Screen {

    final Heidren game;

    public Animation<TextureRegion> runningAnimation;

    public SpriteBatch batch;

    OrthographicCamera camera;

    ShapeRenderer border;

    Stage rootstage;
    Table roottable; // table that holds all the tables
    Table buttonPanelTable;
    TextButton textbutton; // test button
    ButtonPanel buttonPanelObject;

    List<PlayerCharacter> players;

    private ConsoleComponent console;

    public MainMenuScreen(final Heidren game) {

        // all the inits
        this.game = game;
        rootstage = new Stage();
        roottable = new Table();
        buttonPanelTable = new Table();
        console = new ConsoleComponent();
        buttonPanelObject = new ButtonPanel();

        // Heidren.font.getData().setScale(0.5f); // font scale test (broken)

        loadPlayers();

        Gdx.input.setInputProcessor(rootstage);

        // int help_guide = 10; // might not need these
        // int row_height = Gdx.graphics.getHeight() /10;

        //border = new ShapeRenderer(); // add border to main screen, possibly garbage

        roottable.setFillParent(true); // everything should be added to this table
        roottable.pad(10);
        rootstage.addActor(roottable);


        roottable.setDebug(true); // shows table parameters

        // playing with simplified animation (broken)
        //runningAnimation = new Animation<TextureRegion>(0.125f, atlas.findRegions("monk"), Animation.PlayMode.LOOP);

        // test labels for blocking
        Label title = new Label("Isle of Heidren", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label space = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));

        // console add text
        console.appendMessage("Hello, world! what happens if the text goes on for so goddamn long it has to wrap. does it wrap?? what next!!!?!", MessageType.GAME_EVENT); // Game Event Ex.
        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.

        // buttonpanel
        buttonPanelTable = buttonPanelObject.createStoryPanel();

        // root table construction
        roottable.row(); //r1 - title
        roottable.add(title); // r2 c1

        //TODO: figure out images + add stats panel
        roottable.row(); //r2 - image window + stats panel
        roottable.add(space).grow().space(10);// r2 c1 image
        roottable.add(space); //r2 c2 stats

        // TODO: sprite add + animation
        roottable.row(); // r3 - sprites (potentially 4 cols??)
        roottable.add(space);// r3 c1
        roottable.add(space); //r3 c2
        roottable.add(space);//r3 c3

        roottable.row(); // r4 - console + button panel
        roottable.add(console).grow().space(10); //r2c2
        roottable.add(buttonPanelTable).right().top().space(10);//r2c3

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

        //

        // game.batch.begin(); // forget what these are for
        // game.batch.end();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        rootstage.act(Gdx.graphics.getDeltaTime());
        rootstage.draw();

        /*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }*/

        //GAME LOOP GOES HERE?
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

    /*
    Loads all the characters from the character folder into memory
     */
    private void loadPlayers() {
        PlayerCharacterRepo repo = new PlayerCharacterRepo();
        players = new ArrayList<PlayerCharacter>();

        players.add(repo.get("bella"));
    }
}
