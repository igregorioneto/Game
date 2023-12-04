package com.mygdx.game;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.codigo_especifico.CodigoEspecifico;
import com.mygdx.game.codigo_especifico.ICodigoEspecifico;

public class AndroidLauncher extends AndroidApplication implements ICodigoEspecifico {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new CodigoEspecifico(this), config);
	}

	@Override
	public void abrirLink(String s) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
		startActivity(intent);
	}

	@Override
	public void pubScore(int score) {

	}
}
