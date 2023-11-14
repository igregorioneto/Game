package com.mygdx.game.TexturasESprites;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.nio.ByteBuffer;

public class TexturasESprites extends ApplicationAdapter {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;

    private float scale = 0.5f;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        // Carregar a imagem para transformar em uma textura
        texture = new Texture("assets/art/playerGrey_up1.png");
        Gdx.app.log("INFO", "Largura da imagem: " + texture.getWidth());
        Gdx.app.log("INFO", "Altura da imagem: " + texture.getHeight());

        // Colocar a textura no sprite para transformar a textura em sprite
        sprite = new Sprite(texture);
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Desenhar o sprite na tela com o SpriteBatch
        spriteBatch.begin();
        spriteBatch.draw(sprite,100,100, 0,0, sprite.getWidth(), sprite.getHeight(), scale, scale, 0);
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
    }

}
