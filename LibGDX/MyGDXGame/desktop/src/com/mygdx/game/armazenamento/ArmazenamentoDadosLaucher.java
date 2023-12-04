package com.mygdx.game.armazenamento;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.camera.TamanhosDeTela;

public class ArmazenamentoDadosLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("ArmazenandoDados");
        new Lwjgl3Application(new ArmazenandoDados(), config);
    }
}
