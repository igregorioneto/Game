package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Starfish extends BaseActor{
    public Starfish(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture("assets/starfish.png");

        Action spin = Actions.rotateBy(30,1);
        this.addAction(Actions.forever(spin));
    }
}
