package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends BaseEntity {

    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
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
