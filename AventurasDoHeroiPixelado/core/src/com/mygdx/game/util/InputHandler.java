package com.mygdx.game.util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;

import java.util.List;

public class InputHandler implements InputProcessor {
    private List<Interactable> interactableList;
    private Game game;

    public InputHandler(List<Interactable> interactableList, Game game) {
        this.interactableList = interactableList;
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for (Interactable interactable:interactableList) {
            if (interactable.isClicked(screenX, screenY)) {
                interactable.onClick();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
