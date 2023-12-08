package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Obstacle extends Actor {
    private float radius;

    public Obstacle(int x, int y) {
        setX(x);
        setY(y);
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
        shapeRenderer.circle(getX(), getY(), radius);
        shapeRenderer.end();
    }

    public float getRadius() {
        return radius;
    }
}
