package com.mygdx.game.tools;


/**
 *klasa odpowiadająca za wychwytywanie kolizjii
 */
public class CollisionReaction {

    float x, y;
    int width, height;

    /**
     *konstruktor klasy CollisionReaction
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public CollisionReaction (float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     *przesuwanie kolizji waraz z obiektem
     * @param x
     * @param y
     */
    public void move (float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     *sprawdzenie czy objekt koliduje z innym
     * @param rect
     * @return
     */
    public boolean collidesWith (CollisionReaction rect) {
        return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
    }

}
