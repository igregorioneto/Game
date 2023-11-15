package com.mygdx.game.animations;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public abstract class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(Array<TextureRegion> frameTextures, float cycleTime) {
        frames = frameTextures;
        frameCount = frameTextures.size;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float delta) {
        currentFrameTime += delta;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
