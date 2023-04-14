package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.example.pacman.Main.*;

public class DifferentWall extends Rectangle implements MyShapes {
    /**
     * Dette er konstruktørmetoden for differentWall, som er en subklasse av Rectangle
     * DifferentWall er da boksen inni map, helt i midten hvor ghost sin startposisjon er.
     * @param x x posisjonen til differentWall
     * @param y y posisjonen til differentWall
     * @param color fargen til differentWall
     */
    public DifferentWall(int x, int y, Color color) {
        super(x,y,tile, tile);
        setFill(color);
    }

    /**
     * DifferentWall har en update metode som bruker i run() gameloopen i main.
     */
    @Override
    public void update() {
        pane.getChildren().add(this);
    }
}
