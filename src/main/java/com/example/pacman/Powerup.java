package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Iterator;

import static com.example.pacman.Main.*;
import static com.example.pacman.Main.pane;

public class Powerup extends Rectangle {
    public Powerup(int x, int y, Color color){
        super(x,y,tile/4, tile/4);
        setFill(color);
    }

    /**
     * Coins har en update metode som bruker i run() gameloopen i main.
     * Den sjekker også om coins kolliderer med pacman og oppdatere scoren.
     */
    public void update() {
        pane.getChildren().add(this);
    }

    public static void powerPelletRemove(){
        Iterator<Powerup> iterator2 = powerPellets.iterator();
        while (iterator2.hasNext()) {
            Powerup p = iterator2.next();
            p.update();
            if (newPlayer.getBoundsInParent().intersects(p.getBoundsInParent())) {
                iterator2.remove();
                System.out.println("Powerup");
            }
        }
    }
}
