package com.mygdx.game.gerenciando_assets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GerenciandoAssets extends ApplicationAdapter {
    private AssetManager manager;
    private SpriteBatch batch;
    private Texture aviaozinho;

    @Override
    public void create() {
        manager = new AssetManager();

        for (int i = 1; i < 6; i++) {
            manager.load("aviaozinho/Felpudo_Flying000" + i + ".png", Texture.class);
        }
        manager.finishLoading();

        boolean loaded = manager.isLoaded("aviaozinho/Felpudo_Flying0001.png");
        Gdx.app.log("Log", String.valueOf(loaded));

        loaded = manager.isLoaded("aviaozinho/Felpudo_Flying0007.png");
        Gdx.app.log("Log", String.valueOf(loaded));

        batch = new SpriteBatch();
        aviaozinho = manager.get("aviaozinho/Felpudo_Flying0001.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(aviaozinho, 0,0, 100,100);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        aviaozinho.dispose();
    }
}
