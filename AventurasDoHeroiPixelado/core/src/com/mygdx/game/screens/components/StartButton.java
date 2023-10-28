package com.mygdx.game.screens.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.Interactable;

import java.awt.*;

public class StartButton implements Interactable {
    private final Texture buttonTexture;
    private final Rectangle bounds;

    public StartButton() {
        buttonTexture = new Texture(Gdx.files.internal("button_start.png"));
        bounds = new Rectangle(
            Gdx.graphics.getWidth() / 2 - buttonTexture.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - buttonTexture.getHeight() / 2,
                buttonTexture.getWidth(),
                buttonTexture.getHeight()
        );
    }

    public void render(SpriteBatch batch) {
        batch.draw(buttonTexture, bounds.x, bounds.y);
    }

    @Override
    public boolean isClicked(float screenX, float screenY) {
        return bounds.contains(screenX, Gdx.graphics.getHeight() - screenY);
    }

    public void dispose() {
        buttonTexture.dispose();
    }

    @Override
    public void onClick() {

    }
}
