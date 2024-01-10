package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.screens.GameOverScreen;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.tools.GameCamera;
import com.mygdx.game.tools.ScrollingBackground;

/**
 * Klasa odpowiedzialna za przebieg gry, dziedzicząca po głównej klasie frameworka LibGdx "Game".
 */
public class MyGdxGame extends Game {

	/**
	 * Szerokość ekranu gry.
	 */
	public static final int WIDTH = 1024;

	/**
	 * Wysokość ekranu gry.
	 */
	public static final int HEIGHT = 768;

	/**
	 * Flaga określająca, czy gra jest uruchomiona na urządzeniu mobilnym.
	 */
	public static boolean IS_MOBILE = false;

	/**
	 * Czas trwania gry.
	 */
	public static float TIME;

	/**
	 * Aktualny wynik gry.
	 */
	public static int SCORE;

	/**
	 * Aktualny poziom gry.
	 */
	public static int LEVEL;

	/**
	 * Kamera używana w grze.
	 */
	public GameCamera cam;

	/**
	 * Tło poruszające się w grze.
	 */
	public ScrollingBackground scrollingBackground;

	/**
	 * Batch do rysowania obiektów gry.
	 */
	public SpriteBatch batch;

	/**
	 * Metoda inicjująca grę, tworząca obiekt SpriteBatch, kamerę oraz ustawiająca ekran na menu główne.
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		cam = new GameCamera(WIDTH, HEIGHT);
		this.scrollingBackground = new ScrollingBackground();
		this.setScreen(new MainMenuScreen(this));
	}

	/**
	 * Metoda renderująca grę, ustawiająca macierz projekcyjną oraz wywołująca renderowanie ekranu.
	 */
	@Override
	public void render () {
		batch.setProjectionMatrix(cam.combined());
		super.render();
	}

	/**
	 * Metoda pozwalająca na zmianę rozmiaru ekranu gry.
	 *
	 * @param width  nowa szerokość w pikselach
	 * @param height nowa wysokość w pikselach
	 */
	@Override
	public void resize(int width, int height) {
		cam.update(width, height);
		super.resize(width, height);
	}

}
