package com.mygdx.game.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Bird {
    private Texture birdTexture;
    // Posição do pássaro
    private int x, y;
    // Velocidade vertical do pássaro
    private float velocityY;
    // Caixa delimitadora de colisões
    private Rectangle boundingBox;

    public Bird() {
        birdTexture = new Texture("assets/sprites/yellowbird-downflap.png");
        x = 100;
        y = 200;
        velocityY = 0;
        boundingBox = new Rectangle(x, y, birdTexture.getWidth(), birdTexture.getHeight());
    }

    public void update(float delta) {
        // Atualizar a posição do pássaro com base na velocidade
        y += velocityY * delta;
    }

    public void jump() {
        // Ajustando a velocidade vertical
        velocityY = 200;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(birdTexture, x, y);
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

    public float getVelocityY() {
        return velocityY;
    }
}
