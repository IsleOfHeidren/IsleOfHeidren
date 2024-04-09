package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

public class StartScreen implements Screen{

    final Heidren game;

    OrthographicCamera camera;

    ShapeRenderer border;

    Stage stage;
    Table table;

    public StartScreen(final Heidren game) {
        this.game = game;


        int help_guide = 10;
        int row_height = Gdx.graphics.getHeight() /10;

        border = new ShapeRenderer();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);

        stage.addActor(table);




        Label title = new Label("Isle of Heidren", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label start = new Label("Click anywhere to continue", Heidren.skin.optional("default", Label.LabelStyle.class));

        table.add(title);
        table.row();
        table.add(start);

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

        if (Gdx.input.isTouched()){
            game.setScreen(new MainMenuScreen((game)));
            // if screen is clicked then we load the main GUI
            // and dispose of this screen
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
