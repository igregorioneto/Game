package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Bird;

public class GameScreen implements Screen {
    private Bird bird;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture background;

    public GameScreen() {
        bird = new Bird();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 680);
    }

    @Override
    public void show() {
        background = new Texture("assets/sprites/background-day.png");
    }

    @Override
    public void render(float delta) {
        draw();
    }

    private void draw() {
        batch.begin();
        batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(bird.getBirdTexture(), bird.getX(), bird.getY());
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
        batch.dispose();
    }
}
