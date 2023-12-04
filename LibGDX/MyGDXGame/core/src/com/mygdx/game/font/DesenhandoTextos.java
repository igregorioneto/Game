package com.mygdx.game.font;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class DesenhandoTextos extends ApplicationAdapter {
    private SpriteBatch batch;

    private BitmapFont fonte;

    private GlyphLayout glyphLayout;

    @Override
    public void create() {
        batch = new SpriteBatch();

        glyphLayout = new GlyphLayout();

        FreeTypeFontGenerator.setMaxTextureSize(2048);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (0.1 * Gdx.graphics.getHeight());
        parameter.color = new Color(1,1,1,1);
        fonte = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        String texto = "Teste";
        fonte.draw(batch, texto,
                (Gdx.graphics.getWidth() - getWidth(fonte, texto)) / 2,
                Gdx.graphics.getHeight());

        batch.end();
    }

    public float getWidth(BitmapFont font, String texto) {
        glyphLayout.reset();
        glyphLayout.setText(font, texto);
        return glyphLayout.width;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
