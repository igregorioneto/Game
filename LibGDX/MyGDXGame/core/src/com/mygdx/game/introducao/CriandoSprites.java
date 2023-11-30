package com.mygdx.game.introducao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CriandoSprites extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite personagem;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("badlogic.jpg");

        personagem = new Sprite(texture);
        personagem.setPosition(10,10);
        personagem.setSize(100,200);
        personagem.setRotation(120);
        personagem.setFlip(false, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        personagem.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
