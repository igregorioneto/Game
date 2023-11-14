package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.mygdx.game.ManipulacaoDeEntrada.MyGameManipulacaoDeEntrada;
import com.mygdx.game.TexturasESprites.TexturasESprites;

public class TexturasESpritesLaucher {
    public static void main(String[] args) {
        TexturasESprites myProgram = new TexturasESprites();
        Lwjgl3Application laucher = new Lwjgl3Application(myProgram);
    }
}
