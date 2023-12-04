package com.mygdx.game.gerenciando_assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen {

    private Game game;
    private AssetManager manager;

    private SpriteBatch batch;
    private Texture logo;
    private Texture barra;

    private float tempo;

    public SplashScreen(Game game, AssetManager manager) {
        this.game = game;
        this.manager = manager;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        logo = new Texture("Splash/logo.png");
        barra = new Texture("Splash/bar.png");
    }

    @Override
    public void render(float delta) {
        tempo += delta;
        if (manager.update() && tempo >= 2) {
            manager.finishLoading();
            game.setScreen(new MainScreen(game, manager));
        }

        Gdx.gl.glClearColor(6/256f, 123/256f, 141/256f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Desenhando o Logo
        batch.draw(logo, 0.1f * Gdx.graphics.getWidth() , 0.3f * Gdx.graphics.getHeight(),
                0.8f * Gdx.graphics.getWidth(), 0.8f * Gdx.graphics.getWidth());

        batch.draw(barra, 0.1f * Gdx.graphics.getWidth(),
                0.15f * Gdx.graphics.getHeight(),
                Math.min(manager.getProgress(), tempo/2f)*0.8f * Gdx.graphics.getWidth(),
                0.1f * Gdx.graphics.getHeight());

        // Desenhando a barra

        batch.end();
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
