package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block extends BaseEntity {

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
