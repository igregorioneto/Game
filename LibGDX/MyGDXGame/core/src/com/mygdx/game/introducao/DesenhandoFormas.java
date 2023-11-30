package com.mygdx.game.introducao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/*
* Classe para desenhar formas geométricas
*
* @author Greg
* @version 1.0
* @since 2023-11-30
* */
public class DesenhandoFormas extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin();

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(10,10,100,100);

        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(200, 100,100,100);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(200,400,50);

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
    }
}
