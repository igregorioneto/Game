package com.mygdx.game.gerenciando_assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class MainScreen implements Screen {
    private Game game;
    private AssetManager manager;

    public MainScreen(Game game, AssetManager manager) {
        this.game = game;
        this.manager = manager;
    }

    @Override
    public void show() {
        for (int i = 1; i <= 6 ; i++) {
            boolean loaded = manager.isLoaded("aviaozinho/Felpudo_Flying000" + i + ".png");
            Gdx.app.log("Log", String.valueOf(loaded));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

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

    }
}
