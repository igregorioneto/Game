package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Obstacle {
    private float x, y, radius;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
        radius = 20;
    }

    /*
    * Desenhando Obstáculo no formato de um Circulo
    * @param ShapeRender
    * @return
    * */
    public void update(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }
}
