package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tools.CollisionReaction;

/**
 * Klasa reprezentująca kaktusa, który pojawia się na ekranie gry.
 */
public class Cactus {

    // Stałe określające prędkość, szerokość i wysokość kaktusa.
    public static final int SPEED = 500;
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    // Tekstura używana do rysowania kaktusa.
    private static Texture texture;

    // Współrzędne x, y kaktusa oraz prostokąt kolizji.
    float x, y;
    CollisionReaction rect;

    // Flaga określająca, czy kaktus powinien zostać usunięty.
    public boolean remove = false;

    /**
     * Konstruktor klasy Cactus, inicjalizuje współrzędne i prostokąt kolizji.
     *
     * @param x Początkowa współrzędna x kaktusa.
     * @param y Początkowa współrzędna y kaktusa.
     */
    public Cactus(int x, int y){
        this.x = x;
        this.y = y;
        this.rect = new CollisionReaction(x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda aktualizująca stan kaktusa w czasie.
     *
     * @param deltaTime Czas, który upłynął od ostatniej aktualizacji.
     */
    public void update (float deltaTime) {
        // Jeśli kaktus wychodzi poza lewą krawędź ekranu, umieszczamy go ponownie z prawej strony.
        if(x < -150){
            x = 1024;
            y = 10;
            rect.move(x, y);
            return;
        }

        // Aktualizacja współrzędnej x kaktusa na podstawie prędkości i czasu.
        x -= SPEED * deltaTime;

        // Jeśli kaktus wychodzi poza lewą krawędź ekranu, ustawiamy flagę remove na true.
        if (x < -WIDTH)
            remove = true;

        // Aktualizacja współrzędnych prostokąta kolizji.
        rect.move(x, y);
    }

    /**
     * Metoda renderująca kaktusa na ekranie.
     *
     * @param batch Obiekt SpriteBatch do rysowania.
     */
    public void render (SpriteBatch batch) {
        batch.draw(texture, x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda zwracająca prostokąt kolizji kaktusa.
     *
     * @return Prostokąt kolizji.
     */
    public CollisionReaction getCollisionRect () {
        return rect;
    }

    /**
     * Metoda zwracająca współrzędną x kaktusa.
     *
     * @return Współrzędna x kaktusa.
     */
    public float getX () {
        return x;
    }

    /**
     * Metoda zwracająca współrzędną y kaktusa.
     *
     * @return Współrzędna y kaktusa.
     */
    public float getY () {
        return y;
    }

    /**
     * Metoda ustawiająca teksturę kaktusa.
     *
     * @param texture Tekstura do ustawienia.
     */
    public static void setTexture(Texture texture) {
        Cactus.texture = texture;
    }

    /**
     * Metoda zwracająca teksturę kaktusa.
     *
     * @return Tekstura kaktusa.
     */
    public static Texture getTexture() {
        return texture;
    }
}
