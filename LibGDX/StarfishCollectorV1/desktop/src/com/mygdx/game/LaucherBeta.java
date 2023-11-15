package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class LaucherBeta {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(800,600);
        config.setTitle("Starfish Collector V1");
        Game myGame = new StarfishCollectorBeta();
        Lwjgl3Application laucher =
                new Lwjgl3Application(myGame, config);
    }
}
