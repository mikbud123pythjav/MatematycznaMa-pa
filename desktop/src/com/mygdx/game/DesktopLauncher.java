package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

/**
 * Klasa DesktopLauncher odpowiada za uruchomienie gry na platformie desktopowej.
 * Pamiętaj, że na systemie macOS aplikacja musi zostać uruchomiona z argumentem JVM -XstartOnFirstThread.
 */
public class DesktopLauncher {

	/**
	 * Metoda main, uruchamiająca cały program.
	 *
	 * @param arg Argumenty przekazywane podczas uruchamiania programu (nie są używane w tej aplikacji).
	 */
	public static void main(String[] arg) {
		// Konfiguracja aplikacji desktopowej
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60); // Ustawienie liczby klatek na sekundę
		config.setTitle("Matematyczna Malpa"); // Ustawienie tytułu okna
		config.setResizable(false); // Ustawienie, czy okno może być zmieniane rozmiarem
		config.setWindowSizeLimits(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

		// Uruchomienie aplikacji z określoną konfiguracją
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
