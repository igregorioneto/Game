package com.mygdx.game.armazenamento;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ArmazenandoDados extends ApplicationAdapter {
    private Preferences preferences;

    @Override
    public void create() {
        preferences = Gdx.app.getPreferences("usuario1");

        String nome = "Greg";
        preferences.putString("nome", nome);
        preferences.putInteger("score", 150);
        preferences.flush();

        String nomeLido = preferences.getString("nome", "Sem nome!!!");
        int score = preferences.getInteger("score", 0);

        Gdx.app.log("Log", nomeLido);
        Gdx.app.log("Log", String.valueOf(score));

        preferences.remove("nome");
        preferences.flush();

        nomeLido = preferences.getString("nome", "Sem nome!!!");
        Gdx.app.log("Log", nomeLido);

        Gdx.app.log("Log", String.valueOf(preferences.contains("score")));
        Gdx.app.log("Log", String.valueOf(preferences.contains("topscore")));
    }

    @Override
    public void render() {
    }

    @Override
    public void dispose() {
    }
}
