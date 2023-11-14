package com.mygdx.game.CicloDeVida;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class CicloDeVida extends ApplicationAdapter {
    @Override
    public void create() {
        // Inicialização, carregamento de recursos, etc.
        System.out.println("Game Created");
    }

    @Override
    public void render() {
        // Atualiza a lógica do jogo e renderização gráfica
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        System.out.println("Game rendering");
    }

    @Override
    public void resize(int width, int height) {
        // Ajustes quando o tamanho da tela for alterado
        System.out.println("Screen resized: " + width + "x" + height);
    }

    @Override
    public void pause() {
        // Lógica de pausa do jogo
        System.out.println("Game paused");
    }

    @Override
    public void resume() {
        // Lógica de retomada após a pausa
        System.out.println("Game resumed");
    }

    @Override
    public void dispose() {
        // Liberação de recursos ao encerrar o jogo
        System.out.println("Game disposed");
    }
}
