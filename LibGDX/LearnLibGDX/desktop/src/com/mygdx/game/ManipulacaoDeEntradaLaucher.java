package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.mygdx.game.CicloDeVida.CicloDeVida;
import com.mygdx.game.ManipulacaoDeEntrada.MyGameManipulacaoDeEntrada;

public class ManipulacaoDeEntradaLaucher {
    public static void main(String[] args) {
        MyGameManipulacaoDeEntrada myProgram = new MyGameManipulacaoDeEntrada();
        Lwjgl3Application laucher = new Lwjgl3Application(myProgram);
    }
}
