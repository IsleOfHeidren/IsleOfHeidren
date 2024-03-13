package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final Heidren game;

    OrthographicCamera camera;
    //Texture bg;

    ShapeRenderer border;

    Stage stage;
    Table table;

    public MainMenuScreen(final Heidren game) {
        this.game = game;


        int help_guide = 10;
        int row_height = Gdx.graphics.getHeight() /10;

        border = new ShapeRenderer();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);

        //bg = new Texture(Gdx.files.internal("sprites/bg.png"));

//        TextureAtlas atlas;
//        atlas = new TextureAtlas(Gdx.files.internal("skin/skin.json"));
//        FileHandle file = Gdx.files.internal("uiskin/uiskin.atlas");
//        Skin skin = new Skin(file);


        //table.setSkin(skin);

        stage.addActor(table);

        //table.setDebug(true);



        Label title = new Label("Isle of Heidren", Heidren.skin.optional("default", Label.LabelStyle.class));

        table.add(title);

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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }
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
