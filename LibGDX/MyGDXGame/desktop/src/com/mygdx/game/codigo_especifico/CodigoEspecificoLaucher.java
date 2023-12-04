package com.mygdx.game.codigo_especifico;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.animacoes.CriandoAnimacoes;

public class CodigoEspecificoLaucher implements ICodigoEspecifico {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("CriandoAnimacoes");
        new Lwjgl3Application(new CodigoEspecifico(), config);
    }

    @Override
    public void abrirLink(String s) {

    }

    @Override
    public void pubScore(int score) {

    }
}
