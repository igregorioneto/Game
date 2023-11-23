package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.mygdx.game.Animacao.Animacao;
import com.mygdx.game.CicloDeVida.CicloDeVida;

public class AnimacaoLaucher {
    public static void main(String[] args) {
        Animacao myProgram = new Animacao();
        Lwjgl3Application laucher = new Lwjgl3Application(myProgram);
    }
}
