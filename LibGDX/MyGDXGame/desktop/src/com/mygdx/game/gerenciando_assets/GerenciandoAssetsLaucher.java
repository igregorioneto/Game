package com.mygdx.game.gerenciando_assets;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.mudando_tela.MudandoTela;

public class GerenciandoAssetsLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("GerenciandoAssets");
        new Lwjgl3Application(new GerenciandoAssets(), config);
    }
}
