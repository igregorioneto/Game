package com.mygdx.game.camera;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TamanhosDeTela extends Game {
    private SpriteBatch batch;
    private Viewport viewport;
    private Texture texture;

    @Override
    public void create() {
        batch = new SpriteBatch();

        viewport = new FitViewport(1024,1024);

        texture = new Texture("bg.png");
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {

        batch.setProjectionMatrix(viewport.getCamera().combined);

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture, 0, 0, 1024, 1024);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
