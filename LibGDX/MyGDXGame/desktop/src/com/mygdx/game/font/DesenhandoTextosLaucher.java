package com.mygdx.game.font;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.gerenciando_assets.GerenciandoAssets;

public class DesenhandoTextosLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("DesenhandoTextos");
        new Lwjgl3Application(new DesenhandoTextos(), config);
    }
}
