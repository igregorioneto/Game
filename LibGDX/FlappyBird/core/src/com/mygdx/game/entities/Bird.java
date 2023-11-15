package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
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

    // Verificando o estado de queda
    private boolean emQueda;

    // Tamanho do pássaro
    private float scale;

    private float angle;

    // Sprites do pássaro
    private Texture textureBirdDown;
    private Texture textureBirdMid;
    private Texture textureBirdUp;

    private int atrasoSprite = 0;

    private int alturaDaBase;

    // Constantes da Gravidade e Pulo
    private static final float GRAVITY = 500;
    private static final float JUMP_STRENGTH = 350;

    public Bird() {
        // Iniciando as sprites de forma separadas
        textureBirdDown = new Texture("assets/sprites/yellowbird-downflap.png");
        textureBirdMid = new Texture("assets/sprites/yellowbird-midflap.png");
        textureBirdUp = new Texture("assets/sprites/yellowbird-upflap.png");

        x = 150;
        y = 300;
        emQueda = false;
        scale = 1.5f;
        angle = 0;
        velocity = new Vector2(0,0);
        boundingBox = new Rectangle(x, y, textureBirdDown.getWidth(), textureBirdDown.getHeight());
    }

    public void update(float delta) {
        // Atualizar a posição do pássaro com base na velocidade
        velocity.y -= GRAVITY * delta;
        if (isEmQueda()) {
            atrasoSprite++;
            if (atrasoSprite >= 50 && angle > -70) {
                angle -= 5.0f;
            }
        } else {
            atrasoSprite = 0;
            angle = 25.0f;
        }

        // Atualizando a posição do pássaro
        x += velocity.x * delta;
        y += velocity.y * delta;

        // Limitando a posição do pássaro
        if (y < getAlturaDaBase() + 10) {
            y = getAlturaDaBase() + 10;
            setAngle(-70);
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

    public boolean isEmQueda() {
        return emQueda;
    }

    public void setEmQueda(boolean emQueda) {
        this.emQueda = emQueda;
    }

    public float getScale() {
        return scale;
    }

    // Get das Sprites

    public Texture getTextureBirdDown() {
        return textureBirdDown;
    }

    public Texture getTextureBirdMid() {
        return textureBirdMid;
    }

    public Texture getTextureBirdUp() {
        return textureBirdUp;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getAlturaDaBase() {
        return alturaDaBase;
    }

    public void setAlturaDaBase(int alturaDaBase) {
        this.alturaDaBase = alturaDaBase;
    }
}
