package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/*
* Classe principal referente ao PingPong
* @author Greg
* @version 1.0
* @since 2023-12-12
* */
public class PingPong extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle player;
	private Paddle computer;

	private Random random = new Random();

	/*
	 * Método instância inicial do jogo
	 * @param
	 * @return
	 * */
	@Override
	public void create () {
		shape = new ShapeRenderer();
		shape.setColor(Color.WHITE);

		ball = new Ball(random.nextInt(Gdx.graphics.getWidth()),
				random.nextInt(Gdx.graphics.getHeight()),
				8,
				3,
				3);

		// Player
		player = new Paddle(10,
				Gdx.graphics.getHeight() / 2 - 80 / 2, 10, 80, true);

		// Computer
		computer = new Paddle(Gdx.graphics.getWidth() - 20,
				Gdx.graphics.getHeight() / 2 - 80 / 2, 10, 80, false);
	}

	/*
	 * Método atualização do jogo 60FPS
	 * @param
	 * @return
	 * */
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.update();
		player.update();
		computer.update();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		player.draw(shape);
		computer.draw(shape);
		shape.end();

		ball.colisionWith(player);
	}

	/*
	 * Método para tirar valores da memória ao sair do jogo.
	 * @param
	 * @return
	 * */
	@Override
	public void dispose () {
		shape.dispose();
	}
}
