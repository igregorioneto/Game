package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
    private MainGame game;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Texture buttonStart;
    private Texture mouse;

    public MainMenuScreen(MainGame game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = new SpriteBatch();
        this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.buttonStart = new Texture("button_start.png");
        this.mouse = new Texture("mouse.png");

        // Mouse
        mouseCursor();
    }

    private void mouseCursor() {
        int imageWidth = 16;
        int imageHeight = 16;
        float scale = 2f;

        int regionX = 0;
        int regionY = 0;
        int regionWidth = (int) (imageWidth);
        int regionHeight = (int) (imageHeight);

        TextureRegion cursorRegion = new TextureRegion(mouse, regionX, regionY, regionWidth, regionHeight);
        cursorRegion.getTexture().getTextureData().prepare();

        Pixmap cursorPixmap = new Pixmap(regionWidth, regionHeight, Pixmap.Format.RGBA8888);
        cursorPixmap.drawPixmap(cursorRegion.getTexture().getTextureData().consumePixmap(), 0, 0, regionX, regionY, regionWidth, regionHeight);
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(cursorPixmap, regionWidth / 2, regionHeight / 2));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float buttonX = Gdx.graphics.getWidth() / 2 - this.buttonStart.getWidth() / 2;
        float buttonY = Gdx.graphics.getHeight() / 2 - this.buttonStart.getHeight() / 2;

        this.batch.begin();
        this.batch.draw(this.buttonStart, buttonX, buttonY);
        this.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.camera.setToOrtho(false, width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
