package com.mygdx.game.introducao;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TocandoSons extends ApplicationAdapter {
    private Sound sound;

    @Override
    public void create() {
        sound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sound.play(0.1f);
    }

    @Override
    public void dispose() {
    }
}
