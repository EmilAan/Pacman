package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.example.pacman.Ghost.speed1;
import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class Wall extends Rectangle implements MyShapes {

    double playerX, playerY;
    double lastPositionY, lastPositionX;
    double ghostLastPositionX, ghostLastPositionY;

    /**
     * Dette er konstruktørmetoden for wall, som er en subklasse av Rectangle
     * Wall er da alle vegger i map
     * @param x x posisjonen til wall
     * @param y y posisjonen til wall
     * @param color fargen til wall
     */
    public Wall(int x, int y, Color color){
        super(x,y,tile,tile);
        setFill(color);
    }

    /**
     * Wall har en update metode som bruker i run() gameloopen i main.
     * Denne metoden sjekker om pacman treffer en vegg, og hvis han gjør det, så flytter den seg tilbake til siste posisjon.
     * Denne metoden sjekker også om pacman treffer en ghost, og hvis han gjør det, så flytter den ghosten tilbake til siste posisjon.
     * Dette gjør den ved å bruke en random retning, og flytte ghosten deretter.
     */
    public void update(){
        if (!newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            lastPositionY = Player.lastPositionY();
            lastPositionX = Player.lastPositionX();
        }
        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            playerX = newPlayer.getCenterX();
            playerY = newPlayer.getCenterY();
            switch(newPlayer.getDirection()){
                case DOWN -> newPlayer.setCenterY(playerY - speed);
                case UP -> newPlayer.setCenterY(playerY + speed);
                case LEFT -> newPlayer.setCenterX(playerX + speed);
                case RIGHT -> newPlayer.setCenterX(playerX - speed);
            }
            newPlayer.setCenterY(lastPositionY);
            newPlayer.setCenterX(lastPositionX);
        }
        for (Ghost g : ghost) {
            if (!this.getBoundsInParent().intersects(g.getBoundsInParent())) {
                ghostLastPositionY = g.getCenterY();
                ghostLastPositionX = g.getCenterX();
                switch (Retning.randomDirection()) {
                    case DOWN -> g.setCenterY(g.getCenterY() - speed1);
                    case UP -> g.setCenterY(g.getCenterY() + speed1);
                    case LEFT -> g.setCenterX(g.getCenterX() + speed1);
                    case RIGHT -> g.setCenterX(g.getCenterX() - speed1);
                }
            }
            if (this.getBoundsInParent().intersects(g.getBoundsInParent())) {
                Retning tilfeldig = Retning.randomDirection();
                switch (tilfeldig) {
                    case DOWN -> g.setCenterY(g.getCenterY() - speed1);
                    case UP -> g.setCenterY(g.getCenterY() + speed1);
                    case LEFT -> g.setCenterX(g.getCenterX() + speed1);
                    case RIGHT -> g.setCenterX(g.getCenterX() - speed1);
                }
                g.setCenterY(ghostLastPositionY);
                g.setCenterX(ghostLastPositionX);
            }
        }
        pane.getChildren().add(this);
    }
}


