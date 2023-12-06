package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    private int personX, personY, speed;

    public Player() {
        personX = 0;
        personY = 0;
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
        shapeRenderer.rect(personX,personY, 50,50);
        shapeRenderer.end();
    }

    /*
     * Alterando a movimentação do personagem com base nas setas do teclado
     * @param
     * @return
     * */
    private void movimentacaoPlayer() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            personY += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            personY -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            personX -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            personX += speed;
    }

}
