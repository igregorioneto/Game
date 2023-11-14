package com.mygdx.game.TexturasESprites;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TexturasESprites extends ApplicationAdapter {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;

    private float scale = 0.5f;
    private float windowsWidth = 0;
    private float windowsHeight = 0;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        // Carregar a imagem para transformar em uma textura
        texture = new Texture("assets/art/playerGrey_up1.png");

        // Log para verificar a informação da imagem
        Gdx.app.log("INFO", "Largura da imagem: " + texture.getWidth());
        Gdx.app.log("INFO", "Altura da imagem: " + texture.getHeight());

        windowsWidth = Gdx.graphics.getWidth();
        windowsHeight = Gdx.graphics.getHeight();

        // Colocar a textura no sprite para transformar a textura em sprite
        sprite = new Sprite(texture);
        sprite.setPosition(windowsWidth / 2,windowsHeight / 2);
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Chamando método para os inputs do personagem
        handleInput();

        // Desenhar o sprite na tela com o SpriteBatch
        spriteBatch.begin();
        spriteBatch.draw(sprite,sprite.getX(),sprite.getY(), 0,0, sprite.getWidth(), sprite.getHeight(), scale, scale, 0);
        spriteBatch.end();

    }


    /*
    * Método para movimentação do personagem
    * Sem retorno
    * */
    private void handleInput() {
        float moveSpeed = 200f * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Keys.LEFT))
            sprite.translateX(-moveSpeed);
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            sprite.translateX(moveSpeed);
        if (Gdx.input.isKeyPressed(Keys.UP))
            sprite.translateY(moveSpeed);
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            sprite.translateY(-moveSpeed);

        // Limitando a posição do sprite na tela
        sprite.setX(Math.max(0, Math.min(windowsWidth - sprite.getWidth() * scale, sprite.getX())));
        sprite.setY(Math.max(0, Math.min(windowsHeight - sprite.getHeight() * scale, sprite.getY())));
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
    }

}
