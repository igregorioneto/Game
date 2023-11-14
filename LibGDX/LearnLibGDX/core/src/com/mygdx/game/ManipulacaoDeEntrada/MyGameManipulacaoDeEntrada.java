package com.mygdx.game.ManipulacaoDeEntrada;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGameManipulacaoDeEntrada extends Game {
    @Override
    public void create() {
        MyInputProcessor myInputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(myInputProcessor);
    }
}
