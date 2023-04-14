package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static com.example.pacman.Main.ghost;

public class Clyde extends Ghost{
    /**
     * @param scene sceneen som Clyde skal være i
     * @param x x posisjonen til Clyde
     * @param y y posisjonen til Clyde
     * @param radius radiusen til Clyde
     * @param color fargen til Clyde
     */
    public Clyde(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
        ghost.add(this);
    }
}
