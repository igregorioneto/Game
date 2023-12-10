package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int width;
    int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        x = Gdx.input.getX();
        if (x < 0)
            x = 0;
        if (x + width > Gdx.graphics.getWidth())
            x = Gdx.graphics.getWidth() - width;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
