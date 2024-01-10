package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.tools.CollisionReaction;

/**
 * Klasa reprezentująca obiekt banany w grze.
 */
public class Banana {

    /** Stała określająca prędkość poruszania się banana. */
    public static final int SPEED = 80;

    /** Stałe określające szerokość i wysokość banana. */
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    /** Tekstura banana. */
    private static Texture texture;

    /** Pozycja X i Y banana. */
    float x, y;

    /** Obszar kolizji banana. */
    CollisionReaction rect;

    /** Flaga określająca, czy banana powinien zostać usunięty. */
    public boolean remove = false;

    /**
     * Konstruktor klasy Banana, inicjalizuje pozycję i obszar kolizji banana.
     *
     * @param y Początkowa pozycja Y banana.
     */
    public Banana(int y){
        this.x = MyGdxGame.WIDTH;
        this.y = y;
        this.rect = new CollisionReaction(x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda aktualizująca stan banana w czasie.
     *
     * @param deltaTime Czas od ostatniego update'a w sekundach.
     */
    public void update (float deltaTime) {
        y -= SPEED * deltaTime;
        if (y < -HEIGHT)
            remove = true;

        rect.move(x, y);
    }

    /**
     * Metoda renderująca banana na ekranie.
     *
     * @param batch Obiekt SpriteBatch do renderowania.
     */
    public void render (SpriteBatch batch) {
        batch.draw(texture, x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda zwracająca obszar kolizji banana.
     *
     * @return Obszar kolizji banana.
     */
    public CollisionReaction getCollisionRect () {
        return rect;
    }

    /**
     * Metoda zwracająca pozycję X banana.
     *
     * @return Pozycja X banana.
     */
    public float getX () {
        return x;
    }

    /**
     * Metoda zwracająca pozycję Y banana.
     *
     * @return Pozycja Y banana.
     */
    public float getY () {
        return y;
    }
}
