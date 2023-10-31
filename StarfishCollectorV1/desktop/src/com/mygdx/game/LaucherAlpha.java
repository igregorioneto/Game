package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;

public class LaucherAlpha {
    public static void main(String[] args) {
        Game myGame = new StarfishCollectorAlpha();
        Lwjgl3Application laucher =
                new Lwjgl3Application(myGame);
    }
}
