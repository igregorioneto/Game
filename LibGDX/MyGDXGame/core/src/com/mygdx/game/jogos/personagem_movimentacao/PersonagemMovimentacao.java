package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

;

public class PersonagemMovimentacao extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Player player;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        player = new Player();
    }

    @Override
    public void render() {
        // Limpando a tela
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(shapeRenderer);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
