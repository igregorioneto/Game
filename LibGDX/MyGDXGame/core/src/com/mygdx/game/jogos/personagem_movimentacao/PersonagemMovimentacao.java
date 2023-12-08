package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

;import java.util.ArrayList;
import java.util.List;

public class PersonagemMovimentacao extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Player player;
    private List<Obstacle> obstacles = new ArrayList<>();

    private Pontuation pontuation;

    private int time = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        player = new Player();

        for (int i = 0; i < 5; i++) {
            obstacles.add(new Obstacle((int)(Math.random() * Gdx.graphics.getWidth()),
                    (int)(Math.random() * Gdx.graphics.getHeight())));
        }

        pontuation = new Pontuation(0);

    }

    @Override
    public void render() {
        // Limpando a tela
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(shapeRenderer);
        time += 1;
        pontuation.update(batch,time);

        for (int i = 0; i < obstacles.size(); i++) {
            obstacles.get(i).update(shapeRenderer);

            if (CollisionUtils.isCollisionPlayerAndObstacles(player, obstacles.get(i))) {
                Gdx.app.log("LOG", "Colisão detectada!");
            }
        }


    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
