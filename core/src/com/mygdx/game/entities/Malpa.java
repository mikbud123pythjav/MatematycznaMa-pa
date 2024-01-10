package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.tools.CollisionReaction;

/**
 * Klasa reprezentująca obiekt Małpa.
 */
public class Malpa {

    /**
     * Stała określająca prędkość poruszania się obiektu Małpy.
     */
    public static final int SPEED = 80;

    /**
     * Stała określająca szerokość obiektu Małpy.
     */
    public static final int WIDTH = 32;

    /**
     * Stała określająca wysokość obiektu Małpy.
     */
    public static final int HEIGHT = 32;

    /**
     * Tekstura obiektu Małpy.
     */
    private static Texture texture;

    /**
     * Współrzędna x obiektu Małpy.
     */
    float x;

    /**
     * Współrzędna y obiektu Małpy.
     */
    float y;

    /**
     * Obszar kolizji obiektu Małpy.
     */
    CollisionReaction rect;

    /**
     * Flaga informująca, czy obiekt Małpy powinien zostać usunięty.
     */
    public boolean remove = false;

    /**
     * Konstruktor klasy Małpa.
     *
     * @param x Współrzędna x początkowej pozycji obiektu Małpy.
     * @param y Współrzędna y początkowej pozycji obiektu Małpy.
     */
    public Malpa(int x, int y) {
        this.x = x;
        this.y = y;
        this.rect = new CollisionReaction(x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda aktualizująca stan obiektu Małpy.
     *
     * @param deltaTime Czas, który upłynął od ostatniej aktualizacji.
     */
    public void update(float deltaTime) {
        y -= SPEED * deltaTime;
        if (y < -HEIGHT)
            remove = true;

        rect.move(x, y);
    }

    /**
     * Metoda renderująca obiekt Małpy na ekranie.
     *
     * @param batch Obiekt do rysowania na ekranie.
     */
    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, WIDTH, HEIGHT);
    }

    /**
     * Metoda zwracająca obszar kolizji obiektu Małpy.
     *
     * @return Obszar kolizji obiektu Małpy.
     */
    public CollisionReaction getCollisionRect() {
        return rect;
    }

    /**
     * Metoda zwracająca współrzędną x obiektu Małpy.
     *
     * @return Współrzędna x obiektu Małpy.
     */
    public float getX() {
        return x;
    }

    /**
     * Metoda zwracająca współrzędną y obiektu Małpy.
     *
     * @return Współrzędna y obiektu Małpy.
     */
    public float getY() {
        return y;
    }

    /**
     * Metoda ustawiająca teksturę obiektu Małpy.
     *
     * @param texture Tekstura do ustawienia.
     */
    public static void setTexture(Texture texture) {
        Malpa.texture = texture;
    }

    /**
     * Metoda zwracająca teksturę obiektu Małpy.
     *
     * @return Tekstura obiektu Małpy.
     */
    public static Texture getTexture() {
        return texture;
    }

    /**
     * Metoda ustawiająca współrzędną x obiektu Małpy.
     *
     * @param x Nowa wartość współrzędnej x.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Metoda ustawiająca współrzędną y obiektu Małpy.
     *
     * @param y Nowa wartość współrzędnej y.
     */
    public void setY(float y) {
        this.y = y;
    }
}
