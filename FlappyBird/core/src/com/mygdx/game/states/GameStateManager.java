package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        this.states = new Stack();
    }

    // Adicionando state na pilha
    public void push(State state) {
        this.states.push(state);
    }

    // Este método remove o retorno de um objeto no topo da stack
    public void pop() {
        states.pop();
    }

    // Abrir um novo estado
    public void set(State state) {
        states.pop();
        states.push(state);
    }

    // Mudança entre duas renderizações
    public void update(float dt) {
        states.peek().update(dt);
    }

    // Olha para o topo da pilha usando o peek e renderiza na tela
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }
}
