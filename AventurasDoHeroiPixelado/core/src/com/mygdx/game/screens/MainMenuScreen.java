package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.screens.components.StartButton;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenuScreen implements Screen {
    //private List<Interactable> interactableList;
    private Game game;
    private StartButton startButton;
    private SpriteBatch batch;
    //private InputHandler inputHandler;
    private Stage stage;

    public MainMenuScreen(Game game) {
        this.game = game;
        //this.interactableList = new ArrayList<>();
        batch = new SpriteBatch();
        startButton = new StartButton();
        //interactableList.add(startButton);

        //inputHandler = new InputHandler(interactableList, game);
        //Gdx.input.setInputProcessor(inputHandler);

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin();
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_start.png");
        textButtonStyle.down = skin.getDrawable("button_start.png");

        TextButton textButton = new TextButton("Iniciar", textButtonStyle);
        textButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.out.print("Bem vindo ao jogo!");
            }
        });

        stage.addActor(textButton);

    }

    @Override
    public void show() {
        // Quando a tela é exibida
    }

    @Override
    public void render(float delta) {
        // Lógica de renderização do menu principal
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        // Chamado quando a janela é redimensionada
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Chamado quando o jogo é pausado
    }

    @Override
    public void resume() {
        // Chamado quando o jogo é retomado após a pausa
    }

    @Override
    public void hide() {
        // Chamado quando a tela é oculta
    }

    @Override
    public void dispose() {
        // Liberar recursos quando a tela não for mais necessária
        stage.dispose();
    }
}
