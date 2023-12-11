package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends BaseEntity {
    private int xSpeed;
    private int ySpeed;
    private Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        super(x, y, size);
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
        shape.setColor(color);
        shape.circle(x,y, size);
    }

    public void checkCollision(Paddle paddle) {
        if (collideWith(paddle)) {
            ySpeed = -ySpeed;
            color = Color.GREEN;
        } else {
            color = Color.WHITE;
        }
    }

    public void checkColision(Block block) {
        if (collideWith(block)) {
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }

    private boolean collideWith(Paddle paddle) {
        return (x - size >= paddle.x && x - size <= paddle.x + paddle.width)
                && (y - size >= paddle.y && y - size <= paddle.y + paddle.height);
    }

    private boolean collideWith(Block block) {
        return (x + size >= block.x && x + size <= block.x + block.width)
                && (y + size >= block.y && y + size <= block.y + block.height );
    }
}
