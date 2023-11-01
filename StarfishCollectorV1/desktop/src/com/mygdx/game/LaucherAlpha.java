package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class LaucherAlpha {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Starfish Collector V1");
        config.setWindowedMode(800,600);
        Game myGame = new StarfishCollectorAlpha();
        Lwjgl3Application laucher =
                new Lwjgl3Application(myGame, config);
    }
}
