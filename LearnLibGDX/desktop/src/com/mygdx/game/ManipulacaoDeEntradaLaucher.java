package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.mygdx.game.CicloDeVida.CicloDeVida;

public class CicloDeVidaLaucher {
    public static void main(String[] args) {
        CicloDeVida myProgram = new CicloDeVida();
        Lwjgl3Application laucher = new Lwjgl3Application(myProgram);
    }
}
