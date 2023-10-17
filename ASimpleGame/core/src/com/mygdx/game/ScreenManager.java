package com.mygdx.game;

import com.badlogic.gdx.Game;

public class ScreenManager {
    private Game game;

    public ScreenManager(Game game) {
        this.game = game;
    }

    public void showMainMenuScreen() {
        game.setScreen(new MainMenuScreen((Drop) game));
    }

    public void showGameOverScreen(int points) {
        game.setScreen(new GameOverScreen((Drop) game,points));
    }
}
