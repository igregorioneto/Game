package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.screens.MainMenuScreen;

public class AventurasDoHeroiPixelado extends Game {
	
	@Override
	public void create () {
		setScreen(new MainMenuScreen(AventurasDoHeroiPixelado.this));
	}

	@Override
	public void render () {
	}
	
	@Override
	public void dispose () {
	}
}
