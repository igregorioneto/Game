package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends BaseEntity {
    boolean player;
    public Paddle(int x, int y, int width, int height, boolean player) {
        super(x, y, width, height);
        this.player = player;
    }

    public void update(Ball ball) {
        // Player
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && y + height <= Gdx.graphics.getHeight() && player)
            y+= 5;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y >= 0 && player)
            y-=5;

        // Computer
        if (!player) {
            y = ball.y;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
