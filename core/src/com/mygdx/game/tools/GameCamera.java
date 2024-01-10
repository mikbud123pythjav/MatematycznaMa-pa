package com.mygdx.game.tools;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Klasa reprezentująca kamerę w grze, zarządzająca nią oraz koordynująca jej działanie.
 */
public class GameCamera {

    private OrthographicCamera cam; // Obiekt kamery Orthographic
    private StretchViewport viewport; // Obiekt widoku StretchViewport

    /**
     * Konstruktor klasy GameCamera, inicjujący obiekty kamery i widoku.
     *
     * @param width  Szerokość widoku
     * @param height Wysokość widoku
     */
    public GameCamera(int width, int height) {
        cam = new OrthographicCamera();
        viewport = new StretchViewport(width, height, cam);
        viewport.apply();
        cam.position.set((int) width / 2, (int) height / 2, 0);
        cam.update();
    }

    /**
     * Metoda zwracająca złączoną macierz transformacji kamery.
     *
     * @return Złączona macierz transformacji kamery
     */
    public Matrix4 combined() {
        return cam.combined;
    }

    /**
     * Metoda aktualizująca widok kamery na podstawie nowych wymiarów.
     *
     * @param width  Nowa szerokość widoku
     * @param height Nowa wysokość widoku
     */
    public void update(int width, int height) {
        viewport.update(width, height);
    }

    /**
     * Metoda zwracająca wektor wejściowy w przestrzeni gry.
     *
     * @return Wektor wejściowy w przestrzeni gry
     */
    public Vector2 getInputInGameWorld() {
        Vector3 inputScreen = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);
        Vector3 unprojected = cam.unproject(inputScreen);
        return new Vector2(unprojected.x, unprojected.y);
    }
}
