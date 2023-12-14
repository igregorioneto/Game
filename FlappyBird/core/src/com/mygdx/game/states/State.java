package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        this.cam = new OrthographicCamera();
        this.mouse = new Vector3();
    }

    // Lidando com inputs
    public abstract void handleInput();

    // Método de atualização
    public abstract void update(float dt);

    // Método para renderização com o SpriteBatch
    public abstract void render(SpriteBatch batch);

    // Descartar imagens, músicas, evitar vazamento de memória...
    public abstract void dispose();
}
