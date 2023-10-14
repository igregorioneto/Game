package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class ASimpleGame extends ApplicationAdapter {
	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle bucket;
	private Array<Rectangle> raindrops;
	private long lastDropTime;


	@Override
	public void create () {
		// loading dos assets
		dropImage = new Texture(Gdx.files.internal("drop.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		// loading sounds
		dropSound = Gdx.audio.newSound(Gdx.files.internal("junggle.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("underTreeInRain.mp3"));

		// Deixando a música no looping do fundo
		rainMusic.setLooping(true);
		rainMusic.play();

		// Criando câmera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800,400);
		batch = new SpriteBatch();

		// Criando um retângulo para representar um bucket (balde)
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2; // O centro do balde
		bucket.y = 20; // 20 pixels superior a cima
		bucket.width = 64;
		bucket.height = 64;

		// Criando uma matriz com as gotas
		raindrops = new Array<>();
		spawnRaindrop();
	}

	/*
	* Criando a gota e adicionando da lista de gotas (raindrops)
	* E depois colocando o tempo de criação.
	* */
	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800 - 64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void render () {
		// Limpando a tela com a cor azul
		ScreenUtils.clear(0,0,0.2f, 1);

		// Atualizando a câmera
		camera.update();

		// Renderizando o sprite na câmera
		batch.setProjectionMatrix(camera.combined);

		// Desenhando o balde (bucket)
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		// Desenhando as gotas (drops)
		for (Rectangle raindrop:raindrops) {
			batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		batch.end();

		/*
		* Movimentação do balde (bucket)
		* Esta movimentação é referente ao touch
		* */
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
		}

		/*
		* Movimentação do balde (bucket)
		* Esta movimentação é referente as teclas LEFT e RIGHT
		* */
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

		/*
		* Certificando que o Balde (Bucket) continue nos limites da tela.
		* */
		if (bucket.x < 0) bucket.x = 0;
		if (bucket.x > 800 - 64) bucket.x = 800 - 64;

		/*
		* Verificar se precisa criar uma nova gota de chuva
		* */
		if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();


		/*
		* Criando as gotas de chuva na tela e será removido aqueles que tocarem o Balde
		* Ou sairem da tela
		* */
		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext();) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if (raindrop.y + 64 < 0 ) iter.remove();
			// O overlaps é uma condição para verificar se a gota toca do balde
			if (raindrop.overlaps(bucket)) {
				dropSound.play();
				iter.remove();
			}
		}

	}

	@Override
	public void dispose () {
		// Descartando todos os recursos nativos
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}
}
