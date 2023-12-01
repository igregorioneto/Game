package com.mygdx.game.mudando_tela;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class MainScreen implements Screen {
    private Game game;

    public MainScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Limpando a tela
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.justTouched())
            this.game.setScreen(new GameScreen(game));
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("Log", "Resize: " + width + " x " + height);
    }

    @Override
    public void pause() {
        Gdx.app.log("Log", "Pause");
    }

    @Override
    public void resume() {
        Gdx.app.log("Log", "Remuse");
    }

    @Override
    public void hide() {
        Gdx.app.log("Log", "Hide");
    }

    @Override
    public void dispose() {
        Gdx.app.log("Log", "Dispose");
    }
}
