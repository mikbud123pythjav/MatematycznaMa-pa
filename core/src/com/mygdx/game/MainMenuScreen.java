package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {


    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 150;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 150;

    MyGdxGame game;

    Texture exitButton;
    Texture exitButtonTouched;
    Texture playButton;
    Texture playButtonTouched;



    public MainMenuScreen(MyGdxGame game){
        this.game = game;
        playButton = new Texture("play-removebg-preview.png");
        playButtonTouched = new Texture("play-removebg-preview-touched-.png");
        exitButton = new Texture("");
        exitButtonTouched = new Texture("");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        ScreenUtils.clear(1, 1, 1, 0);
        game.batch.begin();

        game.batch.draw(playButton, game., 100, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        game.batch.draw(playButtonTouched, 100, 100, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        if(Gdx.input.getX() < ){
            game.batch.draw(exitButtonTouched, 100, 200, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }
        else{
            game.batch.draw(exitButton, 100, 200, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }


        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

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
