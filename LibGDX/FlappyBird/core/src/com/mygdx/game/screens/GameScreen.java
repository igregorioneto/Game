package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
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

    // Criando os canos
    private Texture pipe;
    private float pipeX1 = Gdx.graphics.getWidth(), pipeX2 = Gdx.graphics.getWidth() + 200;
    private int contadorIniciarAparecimentoDosCanos = 0;
    private float alturaMaxima = +100;
    private float alturaMinima = -100;
    private float alturaCano1 = 0, alturaCano2 = 0;

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
        pipe = new Texture("assets/sprites/pipe-green.png");

        Array<TextureRegion> birdTextures = new Array<>();
        birdTextures.add(new TextureRegion(bird.getTextureBirdDown()));
        birdTextures.add(new TextureRegion(bird.getTextureBirdMid()));
        birdTextures.add(new TextureRegion(bird.getTextureBirdUp()));

        birdAnimation = new BirdAnimation(birdTextures, 0.1f);
    }

    @Override
    public void render(float delta) {
        contadorIniciarAparecimentoDosCanos++;
        draw();
        drawPipe(delta);
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
        bird.setAlturaDaBase(base.getHeight());
        batch.begin();
        batch.draw(base, groundX, 0, 400, base.getHeight());
        batch.draw(base, groundX + 400, 0, 400, base.getHeight());
        batch.end();
    }

    private void drawPipe(float delta) {
        if (contadorIniciarAparecimentoDosCanos > 80) {
            pipeX1 -= 200 * delta;
            pipeX2 -= 200 * delta;

            if (pipeX1 + pipe.getWidth() < 0) {
                pipeX1 = Gdx.graphics.getWidth();
                alturaCano1 = MathUtils.random(alturaMinima, alturaMaxima);
            }

            if (pipeX2 + pipe.getWidth() < 0) {
                pipeX2 = Gdx.graphics.getWidth();
                alturaCano2 = MathUtils.random(alturaMinima, alturaMaxima);
            }

            batch.begin();
            batch.draw(new TextureRegion(pipe), pipeX1, alturaCano1, pipe.getWidth(), pipe.getHeight(), pipe.getWidth(),pipe.getHeight(),1.5f, 1.5f, 0);
            batch.draw(new TextureRegion(pipe), pipeX2, alturaCano2, pipe.getWidth(), pipe.getHeight(), pipe.getWidth(),pipe.getHeight(),1.5f, 1.5f, 0);
            batch.end();
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
        base.dispose();
        background.dispose();
        bird.getTextureBirdMid().dispose();
        bird.getTextureBirdUp().dispose();
        bird.getTextureBirdDown().dispose();
    }
}
