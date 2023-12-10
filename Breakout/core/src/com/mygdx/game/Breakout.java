package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Breakout extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private Random r = new Random();
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(r.nextInt(Gdx.graphics.getWidth()),
				r.nextInt(Gdx.graphics.getHeight()),
						15,
						3,
						3);
		paddle = new Paddle(50, 50, 80,10);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.update();
		paddle.update();

		ball.checkCollision(paddle);

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		shape.end();
	}
}
