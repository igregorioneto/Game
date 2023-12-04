package com.mygdx.game.animacoes;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.camera.TamanhosDeTela;

public class CriandoAnimacoesLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("CriandoAnimacoes");
        new Lwjgl3Application(new CriandoAnimacoes(), config);
    }
}
