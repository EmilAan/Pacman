package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Iterator;
import static com.example.pacman.Main.*;

public class Coins extends Circle implements MyShapes {
    /**
     * @param x x posisjonen til coins
     * @param y y posisjonen til coins
     * @param color fargen til coins
     */
    public Coins(int x, int y, Color color){
        super(x,y,tile/4);
        setFill(color);
    }

    /**
     * Coins har en update metode som bruker i run() gameloopen i main.
     * Den sjekker også om coins kolliderer med pacman og oppdatere scoren.
     */
    public void update() {
        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())){
            System.out.println("Score " + scoreCount);
        }
        pane.getChildren().add(this);
    }
    public static void coinRemove(){
        Iterator<Coins> iterator = coins.iterator();
        while (iterator.hasNext()) {
            Coins c = iterator.next();
            c.update();
            if (newPlayer.getBoundsInParent().intersects(c.getBoundsInParent())) {
                iterator.remove();
                scoreCount++;
            }
        }
    }
}
