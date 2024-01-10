package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tools.ScrollingBackground;

/**
 * Ekran odpowiedzialny za prezentację informacji po zakończeniu gry i przegranej.
 */
public class GameOverScreen implements Screen {

    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_HEIGHT = 100;

    MyGdxGame game;

    int score, highscore;
    Texture gameOverBanner;
    BitmapFont scoreFont;

    /**
     * Konstruktor klasy GameOverScreen z inicjalizacją zmiennych.
     *
     * @param game Obiekt gry.
     */
    public GameOverScreen(MyGdxGame game) {
        this.game = game;

        // Pobierz najlepszy wynik z pliku zapisu
        Preferences prefs = Gdx.app.getPreferences("spacegame");
        this.highscore = prefs.getInteger("highscore", 0);

        // Sprawdź, czy wynik jest lepszy niż najlepszy
        if (MyGdxGame.SCORE > highscore) {
            prefs.putInteger("highscore", MyGdxGame.SCORE);
            prefs.flush();
        }

        // Wczytaj tekstury i czcionki
        gameOverBanner = new Texture("game_over.png");
        scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        game.scrollingBackground.setSpeedFixed(true);
        game.scrollingBackground.setSpeed(ScrollingBackground.DEFAULT_SPEED);
    }

    @Override
    public void show() {
    }

    /**
     * Metoda renderująca ekran informujący o zakończeniu gry.
     *
     * @param delta Czas w sekundach od ostatniego renderowania.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.scrollingBackground.updateAndRender(delta, game.batch);

        game.batch.draw(gameOverBanner, MyGdxGame.WIDTH / 2 - BANNER_WIDTH / 2, MyGdxGame.HEIGHT - BANNER_HEIGHT - 15, BANNER_WIDTH, BANNER_HEIGHT);

        GlyphLayout scoreLayout = new GlyphLayout(scoreFont, "Score: \n" + MyGdxGame.SCORE, Color.WHITE, 0, Align.left, false);
        GlyphLayout highscoreLayout = new GlyphLayout(scoreFont, "Highscore: \n" + highscore, Color.WHITE, 0, Align.left, false);
        scoreFont.draw(game.batch, scoreLayout, MyGdxGame.WIDTH / 2 - scoreLayout.width / 2, MyGdxGame.HEIGHT - BANNER_HEIGHT - 15 * 2);

        float touchX = game.cam.getInputInGameWorld().x, touchY = MyGdxGame.HEIGHT - game.cam.getInputInGameWorld().y;

        GlyphLayout tryAgainLayout = new GlyphLayout(scoreFont, "Try Again");
        GlyphLayout mainMenuLayout = new GlyphLayout(scoreFont, "Main Menu");

        float tryAgainX = MyGdxGame.WIDTH / 2 - tryAgainLayout.width / 2;
        float tryAgainY = MyGdxGame.HEIGHT / 2 - tryAgainLayout.height / 2;
        float mainMenuX = MyGdxGame.WIDTH / 2 - mainMenuLayout.width / 2;
        float mainMenuY = MyGdxGame.HEIGHT / 2 - mainMenuLayout.height / 2 - tryAgainLayout.height - 15;

        // Sprawdź, czy wskaźnik znajduje się nad przyciskiem "Try Again"
        if (touchX >= tryAgainX && touchX < tryAgainX + tryAgainLayout.width && touchY >= tryAgainY - tryAgainLayout.height && touchY < tryAgainY)
            tryAgainLayout.setText(scoreFont, "Try Again", Color.YELLOW, 0, Align.left, false);

        // Sprawdź, czy wskaźnik znajduje się nad przyciskiem "Main Menu"
        if (touchX >= mainMenuX && touchX < mainMenuX + mainMenuLayout.width && touchY >= mainMenuY - mainMenuLayout.height && touchY < mainMenuY)
            mainMenuLayout.setText(scoreFont, "Main Menu", Color.YELLOW, 0, Align.left, false);

        // Jeśli przycisk "Try Again" lub "Main Menu" jest wciśnięty
        if (Gdx.input.isTouched()) {
            // Try Again
            if (touchX > tryAgainX && touchX < tryAgainX + tryAgainLayout.width && touchY > tryAgainY - tryAgainLayout.height && touchY < tryAgainY) {
                this.dispose();
                game.batch.end();
                game.setScreen(new MainGameScreen(game));
                MyGdxGame.SCORE = 0;
                return;
            }

            // Main Menu
            if (touchX > mainMenuX && touchX < mainMenuX + mainMenuLayout.width && touchY > mainMenuY - mainMenuLayout.height && touchY < mainMenuY) {
                this.dispose();
                game.batch.end();
                game.setScreen(new MainMenuScreen(game));
                MyGdxGame.SCORE = 0;
                return;
            }
        }

        // Wyświetl przyciski
        scoreFont.draw(game.batch, tryAgainLayout, tryAgainX, tryAgainY);
        scoreFont.draw(game.batch, mainMenuLayout, mainMenuX, mainMenuY);

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
