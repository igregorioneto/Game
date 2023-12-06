package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.introducao.TocandoSons;

public class PersonagemMovimentacaoLaucher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("PersonagemMovimentacao");
        new Lwjgl3Application(new PersonagemMovimentacao(), config);
    }
}
