package com.mygdx.game.animacoes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CriandoAnimacoes extends Game {
    private SpriteBatch batch;
    private Texture[] coracao;
    private Animation<Texture> animacao;
    private float tempo;

    // Outra forma para animação
    private float tempoProx;
    private int frameAtual;

    @Override
    public void create() {
        batch = new SpriteBatch();

        coracao = new Texture[6];
        for (int i = 1; i <= coracao.length ; i++) {
            coracao[i - 1] = new Texture("coracao_animado/Coracao_Idle000"+ i +".png");
        }
        animacao = new Animation<>(0.2f, coracao);
        tempo = 0;

        // Outra forma para animação
        tempoProx = 0.2f;
        frameAtual = 0;
    }

    @Override
    public void render() {
        tempo += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Outra forma para animação
        tempoProx -= Gdx.graphics.getDeltaTime();
        if (tempoProx <= 0) {
            tempoProx = 0.2f;
            frameAtual++;
            if (frameAtual == 6) frameAtual = 0;
        }

        batch.begin();

        batch.draw(animacao.getKeyFrame(tempo, true), 10,10,100,100);

        // Outra forma para animação
        batch.draw(coracao[frameAtual], 200,50, 100,100);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
