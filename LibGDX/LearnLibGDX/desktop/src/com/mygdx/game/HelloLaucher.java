package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.mygdx.game.HelloWorld.HelloWorldImage;

public class HelloLaucher {
    public static void main(String[] args) {
        HelloWorldImage myProgram = new HelloWorldImage();
        Lwjgl3Application laucher = new Lwjgl3Application(myProgram);
    }
}
