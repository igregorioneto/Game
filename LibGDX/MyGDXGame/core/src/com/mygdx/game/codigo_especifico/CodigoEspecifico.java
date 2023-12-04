package com.mygdx.game.codigo_especifico;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class CodigoEspecifico extends ApplicationAdapter {
    private ICodigoEspecifico codigoEspecifico;

    public CodigoEspecifico() {
    }

    public CodigoEspecifico(ICodigoEspecifico codigoEspecifico) {
        this.codigoEspecifico = codigoEspecifico;
    }

    @Override
    public void create() {
    }

    @Override
    public void render() {
        if (Gdx.input.justTouched()) codigoEspecifico.abrirLink("https://www.google.com/");
    }

    @Override
    public void dispose() {
    }
}
