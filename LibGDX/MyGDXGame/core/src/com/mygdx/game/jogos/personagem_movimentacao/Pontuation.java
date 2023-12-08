package com.mygdx.game.jogos.personagem_movimentacao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pontuation {
    private int score;
    private BitmapFont fonte;


    public Pontuation(int score) {
        this.score = score;
        fonte = new BitmapFont();
    }

    public void update(SpriteBatch batch, int time) {
        batch.begin();
        if (time % 100 == 0) {
            score += 1;
            fonte.draw(batch, pontuation(score),
                    50, 50);
        }
        batch.end();
    }

    public String pontuation(int score) {
        return "Pontuação: " + score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
