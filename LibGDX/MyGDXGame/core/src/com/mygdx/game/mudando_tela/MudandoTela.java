package com.mygdx.game.mudando_tela;

import com.badlogic.gdx.Game;

public class MudandoTela extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen(this));
    }
}
