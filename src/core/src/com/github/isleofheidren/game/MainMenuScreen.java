package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen{

    final Heidren game;

    OrthographicCamera camera;
    Texture bg;

    ShapeRenderer border;

    Stage stage;
    Table table;
    Table table1;
    Button button;

    public MainMenuScreen(final Heidren game) {
        this.game = game;


        int help_guide = 10;
        int row_height = Gdx.graphics.getHeight() /10;

        border = new ShapeRenderer();

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table1 = new Table();
        table.setFillParent(true);

        bg = new Texture(Gdx.files.internal("sprites/bg.png"));

//        TextureAtlas atlas;
//        atlas = new TextureAtlas(Gdx.files.internal("skin/skin.json"));
//        FileHandle file = Gdx.files.internal("uiskin/uiskin.atlas");
//        Skin skin = new Skin(file);


        //table.setSkin(skin);
        button = new Button(Heidren.skin);

        stage.addActor(table);

        table.setDebug(true);


        // what i'm trying to do here is block out table spaces
        Label title = new Label("this is the next screen", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label space = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));

        table1.add(button);

        table.row().expand(); //r1
        table.add(title);// r1 c1
        table.add(button); //r1 c2
        table.add(space);//r1c3

        table.row().expand();
        table.add(space);// r2 c1
        table.add(space); //r2c2
        table.add(space);//r2c3

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();

        table.row().expand();




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
        game.batch.begin();

        game.batch.end();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        /*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }*/
    }

    @Override
    public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
    }

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
    public void dispose() {
        stage.dispose();
    }
}
