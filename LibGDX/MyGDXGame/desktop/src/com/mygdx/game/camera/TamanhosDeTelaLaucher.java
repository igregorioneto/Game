package com.mygdx.game.camera;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class TamanhosDeTelaLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("TamanhosDeTela");
        new Lwjgl3Application(new TamanhosDeTela(), config);
    }
}
