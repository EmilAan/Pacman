package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import static com.example.pacman.Main.*;

public class Ghost extends Circle implements MyShapes {
    Scene scene;
    public static Retning retningspøkelse;
    public static double speed1 = 0.3;


    /**
     * Dette er konstruktørmetoden for ghost, og er superklasse for hver av de 4 ghostene
     * @param scene scenen som pøkelsen skal være i
     * @param x x posisjonen til ghost
     * @param y y posisjonen til ghost
     * @param radius radiusen til ghost
     */
    public Ghost(Scene scene, double x, double y, double radius) {
        super(x, y, radius);
        this.scene = scene;
        retningspøkelse = Retning.NONE;

    }

    /**
     * Ghost har en update metode som brukes i run() gameloopen i main.
     * Den håndterer bevegelse av ghost, og sjekker om ghost kolliderer med pacman.
     */
    public void update() {
        switch (retningspøkelse) {
            case DOWN -> setCenterY(getCenterY() - speed1);
            case UP -> setCenterY(getCenterY() + speed1);
            case LEFT -> setCenterX(getCenterX() + speed1);
            case RIGHT -> setCenterX(getCenterX() - speed1);
        }

        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())){
            newPlayer.setCenterY(55);
            newPlayer.setCenterX(55);
            playerHealth = playerHealth - 1;
            System.out.println(playerHealth);
        }

    pane.getChildren().add(this);
    }
}