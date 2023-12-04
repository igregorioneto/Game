package com.mygdx.game.camera;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.introducao.CriandoSprites;

public class UtilizandoCameraLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("UtilizandoCamera");
        new Lwjgl3Application(new UtilizandoCamera(), config);
    }
}
