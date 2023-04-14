package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static com.example.pacman.Main.*;

public class Blinky extends Ghost {
    /**
     * Dette er konstruktørmetoden for Blinky
     * @param scene sceneen som blinky skal være i
     * @param x x posisjonen til blinky
     * @param y y posisjonen til blinky
     * @param radius radiusen til blinky
     * @param color fargen til blinky
     */
    public Blinky(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
        ghost.add(this);
    }
}
