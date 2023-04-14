package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static com.example.pacman.Main.ghost;

public class Inky extends Ghost{
    /**
     * Dette er konstruktørmetoden for Inky, som er en subklasse av Ghost
     * @param scene scenen som Inky skal være i
     * @param x x posisjonen til Inky
     * @param y y posisjonen til Inky
     * @param radius radiusen til Inky
     * @param color fargen til Inky
     */
    public Inky(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
        ghost.add(this);
    }
}

