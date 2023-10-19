package com.mygdx.game.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Bird {
    private Texture birdTexture;
    // Posição do pássaro
    private int x, y;
    // Velocidade vertical do pássaro
    private Vector2 velocity;
    // Caixa delimitadora de colisões
    private Rectangle boundingBox;

    // Constantes da Gravidade e Pulo
    private static final float GRAVITY = 500;
    private static final float JUMP_STRENGTH = 250;

    public Bird() {
        birdTexture = new Texture("assets/sprites/yellowbird-downflap.png");
        x = 100;
        y = 200;
        velocity = new Vector2(0,0);
        boundingBox = new Rectangle(x, y, birdTexture.getWidth(), birdTexture.getHeight());
    }

    public void update(float delta) {
        // Atualizar a posição do pássaro com base na velocidade
        velocity.y -= GRAVITY * delta;

        // Atualizando a posição do pássaro
        x += velocity.x * delta;
        y += velocity.y * delta;

        // Limitando a posição do pássaro
        if (y < 0) {
            y = 0;
            velocity.y = 0;
        }

        if (y >= 680) {
            y = 680;
            velocity.y = 0;
        }

        boundingBox.x = x;
        boundingBox.y = y;
    }

    public void jump() {
        // Ajustando a velocidade vertical
        velocity.y = JUMP_STRENGTH;
    }

    public void draw(SpriteBatch batch) {
        float scale = 0.2f;
        batch.begin();
        batch.draw(birdTexture, x, y,0,0, birdTexture.getWidth(), birdTexture.getHeight());
        batch.end();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public Texture getBirdTexture() {
        return birdTexture;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
