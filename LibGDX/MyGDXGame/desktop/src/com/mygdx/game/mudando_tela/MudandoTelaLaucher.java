package com.mygdx.game.mudando_tela;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.introducao.TocandoSons;

public class MudandoTelaLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("MudandoTela");
        new Lwjgl3Application(new MudandoTela(), config);
    }
}
