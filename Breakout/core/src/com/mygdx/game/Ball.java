package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x - size < 0 || x > Gdx.graphics.getWidth() - size)
            xSpeed = -xSpeed;
        if (y - size < 0 || y > Gdx.graphics.getHeight() - size)
            ySpeed = -ySpeed;
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x,y, size);
    }
}
