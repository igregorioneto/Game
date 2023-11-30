package com.mygdx.game.introducao;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class TrabalhandoComInputsLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("CriandoSprites");
        new Lwjgl3Application(new TrabalhandoComInputs(), config);
    }
}
