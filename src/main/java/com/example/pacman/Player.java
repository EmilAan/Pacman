package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static com.example.pacman.Main.*;

public class Player extends Circle implements MyShapes {
    Scene scene;
    private static Retning retning;
    public static double speed = 1.5;

    /**
     * @param scene sceneen som player skal være i
     * dette er konstruktørmetoden for player, som er en subklasse av Circle
     * Den har en switch som sier hvilke knapper som går hvilke retninger
     */
    public Player(Scene scene) {
        super(55,55,tile/3);
        setFill(Color.YELLOW);
        this.scene = scene;
        retning = Retning.NONE;
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W -> retning = Retning.UP;
                case A -> retning = Retning.LEFT;
                case S -> retning = Retning.DOWN;
                case D -> retning = Retning.RIGHT;
            }
        });
    }

    /**
     * Player har en update metode som brukes i run() gameloopen i main.
     * Den håndterer bevegelse av player, og sjekker om player kolliderer med ghost.
     * Den sjekker også om player kolliderer med wall, og da stopper den.
     */
    public void update(){
        switch(retning){
          case DOWN -> setCenterY(getCenterY() + speed);
          case UP -> setCenterY(getCenterY() - speed);
          case LEFT -> setCenterX(getCenterX() - speed);
          case RIGHT -> setCenterX(getCenterX() + speed);
        }
        pane.getChildren().add(this);
    }

    /**
     * @return retning returnerer retningen til player
     */
    public Retning getDirection() {
        return retning;
    }

    /**
     * @return lastPositionY returnerer y posisjonen til player
     */
    public static double lastPositionY() {
        return newPlayer.getCenterY();
    }

    /**
     * @return lastPositionX returnerer x posisjonen til player
     */
    public static double lastPositionX() {
        return newPlayer.getCenterX();
    }
}


