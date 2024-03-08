package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final Heidren game;
    OrthographicCamera camera;
    Stage stage;
    OutputTerminal outputTerminal;

    public MainMenuScreen(final Heidren game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 600);

        stage = new Stage();
        outputTerminal = new OutputTerminal();
        stage.addActor(outputTerminal.getScrollPane());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        // Rendering game content
        game.batch.end();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            dispose();
        }

        outputTerminal.appendMessage("Welcome to Isle of Heidren!", OutputTerminal.MessageType.GAME_EVENT);
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
