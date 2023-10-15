package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {
    Drop game;
    int points;

    OrthographicCamera camera;

    public GameOverScreen(Drop game, final int points) {
        this.game = game;
        this.points = points;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);

        // Utilizando as informações da classe Drop
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Game Over!! Your final score: " + points, 100, 150);
        game.font.draw(game.batch, "Tap anywhere to Menu!!", 100, 100);
        game.batch.end();

        // Ao tocar na tela ir para o Menu
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenuScreen(new Drop()));
        }

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
        game.dispose();
    }
}
