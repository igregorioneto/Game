package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Drop extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    ScreenManager screenManager;
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(); // Font default da libgdx
        screenManager = new ScreenManager(this);
        screenManager.showMainMenuScreen();
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
