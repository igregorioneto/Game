package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.animations.BirdAnimation;
import com.mygdx.game.entities.Bird;

public class GameScreen implements Screen {
    private Bird bird;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture background;

    // Criando o chão movimentando
    private float groundX = 0;
    private Texture base;

    private BirdAnimation birdAnimation;

    // Desenhando um campo de colisão
    ShapeRenderer shapeRenderer;

    public GameScreen() {
        bird = new Bird();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 680);

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        background = new Texture("assets/sprites/background-day.png");
        base = new Texture("assets/sprites/base.png");

        Array<TextureRegion> birdTextures = new Array<>();
        birdTextures.add(new TextureRegion(bird.getTextureBirdDown()));
        birdTextures.add(new TextureRegion(bird.getTextureBirdMid()));
        birdTextures.add(new TextureRegion(bird.getTextureBirdUp()));

        birdAnimation = new BirdAnimation(birdTextures, 0.1f);
    }

    @Override
    public void render(float delta) {
        draw();
        drawGround(delta);
        bird.update(delta);
        float scale = bird.getScale();
        // Desenhando o pássaro
        batch.begin();

        /*if (bird.isEmQueda()) {
            batch.draw(new TextureRegion(bird.getTextureBirdMid()), bird.getX(), bird.getY(), 0, 0, birdAnimation.getFrame().getRegionWidth(), birdAnimation.getFrame().getRegionHeight(), scale, scale, 0);
        } else {
            batch.draw(birdAnimation.getFrame(), bird.getX(), bird.getY(), 0, 0, birdAnimation.getFrame().getRegionWidth(), birdAnimation.getFrame().getRegionHeight(), scale, scale, bird.getAngle());
        }*/


        batch.draw(birdAnimation.getFrame(), bird.getX(), bird.getY(), 0, 0, birdAnimation.getFrame().getRegionWidth(), birdAnimation.getFrame().getRegionHeight(), scale, scale, bird.getAngle());


        birdAnimation.update(delta);
        batch.end();

        // Desenhando o campo de colisão
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(bird.getBoundingBox().x, bird.getBoundingBox().y, bird.getBoundingBox().width * 1.5f, bird.getBoundingBox().height * 1.5f);
        shapeRenderer.end();

        if (Gdx.input.justTouched()) {
            bird.jump();
            bird.setEmQueda(false);
            bird.setAngle(25.0f);
        } else {
            bird.setEmQueda(true);
        }
    }

    private void drawGround(float delta) {
        groundX -= 200 * delta;
        if (groundX < -base.getWidth()) {
            groundX = 0;
        }

        batch.begin();
        batch.draw(base, groundX, 0, 400, base.getHeight());
        batch.draw(base, groundX + 400, 0, 400, base.getHeight());
        batch.end();
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
        base.dispose();
        background.dispose();
        bird.getTextureBirdMid().dispose();
        bird.getTextureBirdUp().dispose();
        bird.getTextureBirdDown().dispose();
    }
}
