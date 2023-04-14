package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import static com.example.pacman.Main.*;

public class Pinky extends Ghost{
    /**
     * Dette er konstruktørmetoden for Pinky, som er en subklasse av Ghost
     * @param scene sceneen som Pinky skal være i
     * @param x x posisjonen til Pinky
     * @param y y posisjonen til Pinky
     * @param radius radiusen til Pinky
     * @param color fargen til Pinky
     */
    public Pinky(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
        ghost.add(this);
    }
}
