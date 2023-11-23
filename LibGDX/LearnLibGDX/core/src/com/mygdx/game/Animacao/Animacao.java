package com.mygdx.game.Animacao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animacao extends ApplicationAdapter {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private PlayerAnimation playerAnimation;


    // Animação
    private Animation<TextureRegion> animation;
    private TextureRegion[] textureRegions;
    private float stateTime;

    private int windowsWidth = 0;
    private int windowsHeight = 0;
    private float speed = 400f;
    private float scale = 0.5f;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        texture = new Texture("assets/art/playerGrey_walk1.png");

        sprite = new Sprite(texture);

        windowsWidth = Gdx.graphics.getWidth();
        windowsHeight = Gdx.graphics.getHeight();
        sprite.setPosition(windowsWidth / 2, windowsHeight / 2);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        spriteBatch.begin();
        spriteBatch.draw(sprite, sprite.getX(), sprite.getY(), 0,0, sprite.getWidth(), sprite.getHeight(), scale, scale,0);
        spriteBatch.end();
    }

    /*
     * Método para movimentação do personagem
     * Sem retorno
     * */
    private void handleInput() {
        float moveSpeed = speed * Gdx.graphics.getDeltaTime();

        String[] fileNames = {
                "assets/art/playerGrey_walk1.png",
                "assets/art/playerGrey_walk2.png",
        };

        playerAnimation = new PlayerAnimation(fileNames,0.1f);


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprite.translateX(-moveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprite.translateX(moveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            sprite.translateY(moveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            sprite.translateY(-moveSpeed);

        // Limitando a posição do sprite na tela
        sprite.setX(Math.max(0, Math.min(windowsWidth - sprite.getWidth() * scale, sprite.getX())));
        sprite.setY(Math.max(0, Math.min(windowsHeight - sprite.getHeight() * scale, sprite.getY())));
    }

    @Override
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
