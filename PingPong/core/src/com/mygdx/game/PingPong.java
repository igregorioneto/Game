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

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		shape.end();

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
