package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseActor extends Actor {
    public BaseActor(float x, float y, Stage s) {
        // call constructor from Actor class
        super();
        // perform additional initialization tasks
        setPosition(x, y);
        s.addActor(this);
    }
}
