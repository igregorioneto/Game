package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/*
 * Classe da Bola
 * @author Greg
 * @version 1.0
 * @since 2023-12-12
 * */
public class Ball extends BaseEntity{
    int xSpeed, ySpeed;
    private Color color = new Color(Color.WHITE);

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        super(x, y, size);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /*
     * Método de atualização da bola
     * @param
     * @return
     * */
    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x - size < 0 || x + size > Gdx.graphics.getWidth())
            xSpeed = -xSpeed;

        if (y - size < 0 || y + size > Gdx.graphics.getHeight())
            ySpeed = -ySpeed;
    }

    /*
     * Método responsável por desenhar a bola na tela
     * @param ShapeRender para renderização de uma forma geométrica
     * @return
     * */
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }

    public void colisionWith(Paddle paddle) {
        if (collision(paddle)) {
            Gdx.app.log("Log", "Colidindo com a bola!");
            color.set(Color.GREEN);
            xSpeed = -xSpeed;
        }
    }

    private boolean collision(Paddle paddle) {
        return (x - size * 2 <= paddle.x) && (y + size >= paddle.y && y <= paddle.y + paddle.height);
    }

}
