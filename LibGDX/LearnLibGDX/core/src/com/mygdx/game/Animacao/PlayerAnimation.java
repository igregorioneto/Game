package com.mygdx.game.Animacao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimation {
    private Animation<TextureRegion> animation;
    private float stateTime = 0f;

    /*
    * Animação em arquivos separados
    * @param frames Espera receber como parâmetro os frames de um array de Texture para
    * aquela determinada animação
    * @param duração de passagem dos frames
    * */
    public PlayerAnimation(String[] fileNames, float frameDuration) {
        TextureRegion[] animationFrames = new TextureRegion[fileNames.length];

        for (int i = 0; i < fileNames.length; i++) {
            animationFrames[i] = new TextureRegion(new Texture(fileNames[i]));
        }

        animation = new Animation<>(frameDuration, animationFrames);
    }

    /*
    * @param recebe o delta time
    * Ficará passando as informações referente aos frames com base no stateTime
    * */
    public TextureRegion getKeyFrame(float dt) {
        stateTime += dt;
        return animation.getKeyFrame(stateTime, true);
    }
}
