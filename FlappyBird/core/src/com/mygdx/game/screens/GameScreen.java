package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.animations.BirdAnimation;
import com.mygdx.game.entities.Bird;

public class GameScreen implements Screen {
    private Bird bird;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture background;

    private BirdAnimation birdAnimation;

    public GameScreen() {
        bird = new Bird();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 680);
    }

    @Override
    public void show() {
        background = new Texture("assets/sprites/background-day.png");

        Array<TextureRegion> birdTextures = new Array<>();
        birdTextures.add(new TextureRegion(new Texture("assets/sprites/yellowbird-downflap.png")));
        birdTextures.add(new TextureRegion(new Texture("assets/sprites/yellowbird-midflap.png")));
        birdTextures.add(new TextureRegion(new Texture("assets/sprites/yellowbird-upflap.png")));

        birdAnimation = new BirdAnimation(birdTextures, 0.3f);
    }

    @Override
    public void render(float delta) {
        draw();
        bird.update(delta);

        birdAnimation.update(delta);
        batch.begin();
        float scale = 1.5f; // 2x maior
        batch.draw(birdAnimation.getFrame(), bird.getX(), bird.getY(), 0, 0, birdAnimation.getFrame().getRegionWidth(), birdAnimation.getFrame().getRegionHeight(), scale, scale, 0);
        batch.end();

        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    private void draw() {
        batch.begin();
        batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
