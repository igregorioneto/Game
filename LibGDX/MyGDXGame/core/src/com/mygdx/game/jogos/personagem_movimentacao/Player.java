package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.*;

public class Player extends Actor {
    private int speed;

    public Player() {
        setX(0);
        setY(0);
        setWidth(50);
        setHeight(50);

        speed = 5;
    }

    /*
    * Desenhando personagem com ShapeRender
    * @param ShapeRender
    * @return
    * */
    public void update(ShapeRenderer shapeRenderer) {
        // Chamando a movimentação do personagem
        movimentacaoPlayer();

        shapeRenderer.begin();
        shapeRenderer.setColor(Color.RED);
        // para a forma ser preenchida, caso queira somente as bordas usar o 'ShapeRenderer.ShapeType.Line'
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(getX(),getY(), getWidth(),getHeight());
        shapeRenderer.end();
    }

    /*
     * Alterando a movimentação do personagem com base nas setas do teclado
     * @param
     * @return
     * */
    private void movimentacaoPlayer() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            setY(getY() + speed);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            setY(getY() - speed);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            setX(getX() - speed);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            setX(getX() + speed);
    }

    public int getSpeed() {
        return speed;
    }
}
