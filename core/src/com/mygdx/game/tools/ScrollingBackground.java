package com.mygdx.game.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.MyGdxGame;

/**
 * Klasa ScrollingBackground odpowiadająca za przewijanie tła menu w grze.
 */
public class ScrollingBackground {

    public static final int DEFAULT_SPEED = 80;
    public static final int ACCELERATION = 50;
    public static final int GOAL_REACH_ACCELERATION = 200;

    Texture image;
    float y1, y2;
    int speed;  // In pixels/second
    int goalSpeed;
    float imageScale;
    boolean speedFixed;

    /**
     * Konstruktor klasy ScrollingBackground, inicjalizuje obiekt Texture i ustawia początkowe wartości.
     */
    public ScrollingBackground() {
        image = new Texture("rolkaDoMenuGłównego.jpg");

        y1 = image.getHeight();
        y2 = 0;
        speed = 0;
        goalSpeed = DEFAULT_SPEED;
        imageScale = MyGdxGame.WIDTH / image.getWidth();
        speedFixed = true;
    }

    /**
     * Metoda aktualizująca i renderująca tło obrazka.
     *
     * @param deltaTime czas od ostatniego kroku gry
     * @param batch     obiekt SpriteBatch do rysowania
     */
    public void updateAndRender(float deltaTime, SpriteBatch batch) {
        // Dostosowanie prędkości do osiągnięcia celu
        if (speed < goalSpeed) {
            speed += GOAL_REACH_ACCELERATION * deltaTime;
            if (speed > goalSpeed)
                speed = goalSpeed;
        } else if (speed > goalSpeed) {
            speed -= GOAL_REACH_ACCELERATION * deltaTime;
            if (speed < goalSpeed)
                speed = goalSpeed;
        }

        if (!speedFixed)
            speed += ACCELERATION * deltaTime;

        y1 -= speed * deltaTime;
        y2 -= speed * deltaTime;

        // Jeśli obrazek dotarł do dolnej krawędzi ekranu i nie jest widoczny, umieść go z powrotem na górze
        if (y2 + image.getHeight() * imageScale <= 0)
            y1 = y2 + image.getHeight() * imageScale;

        // Renderowanie
        batch.draw(image, y2, 0, MyGdxGame.WIDTH, image.getHeight() * imageScale);
        batch.draw(image, y1, 0, MyGdxGame.WIDTH, image.getHeight() * imageScale);
        batch.draw(image, y1, 0, MyGdxGame.WIDTH, image.getHeight() * imageScale);
        batch.draw(image, y1, 0, MyGdxGame.WIDTH, image.getHeight() * imageScale);
    }

    /**
     * Ustawia docelową prędkość przewijania.
     *
     * @param goalSpeed docelowa prędkość
     */
    public void setSpeed(int goalSpeed) {
        this.goalSpeed = goalSpeed;
    }

    /**
     * Ustawia, czy prędkość jest stała.
     *
     * @param speedFixed true, jeśli prędkość ma być stała, false w przeciwnym razie
     */
    public void setSpeedFixed(boolean speedFixed) {
        this.speedFixed = speedFixed;
    }

}
