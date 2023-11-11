package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture jogador;
	private Vector2 posicaoJogador;
	private float escalaJogador = 2.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		jogador = new Texture("sPlayer.png");
		posicaoJogador = new Vector2(
				Gdx.graphics.getWidth() / 2 - jogador.getWidth() * escalaJogador / 2, Gdx.graphics.getHeight() / 2 - jogador.getHeight() * escalaJogador / 2);
	}

	@Override
	public void render () {
		// Limpando a tela
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update();

		batch.begin();
		batch.draw(jogador,
				posicaoJogador.x,
				posicaoJogador.y,
				jogador.getWidth() * escalaJogador,
				jogador.getHeight() * escalaJogador);
		batch.end();
	}

	public void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			posicaoJogador.x -= 200 * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			posicaoJogador.x += 200 * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			posicaoJogador.y += 200 * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			posicaoJogador.y -= 200 * Gdx.graphics.getDeltaTime();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		jogador.dispose();
	}
}
