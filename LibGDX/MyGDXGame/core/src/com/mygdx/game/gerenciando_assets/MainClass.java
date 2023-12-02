package com.mygdx.game.gerenciando_assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class MainClass extends Game {
    private AssetManager manager;
    @Override
    public void create() {
        manager = new AssetManager();

        for (int i = 1; i <= 6; i++) {
            manager.load("aviaozinho/Felpudo_Flying000" + i + ".png", Texture.class);
        }

        setScreen(new SplashScreen(this, manager));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
