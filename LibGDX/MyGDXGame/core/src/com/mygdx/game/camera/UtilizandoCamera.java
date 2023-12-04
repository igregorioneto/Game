package com.mygdx.game.camera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UtilizandoCamera extends ApplicationAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture texture;

    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        texture = new Texture("bg.png");
    }

    @Override
    public void render() {
        float time = Gdx.graphics.getDeltaTime();
        camera.translate(50 * time, 50 * time);
        camera.zoom += time / 15;
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture, -1000, -1000, 3000, 5000);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
