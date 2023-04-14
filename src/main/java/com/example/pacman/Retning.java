package com.example.pacman;

/**
 * Enum for å holde på retningene
 */
public enum Retning {
    UP, DOWN, LEFT, NONE, RIGHT;

    /**
     * Metode for å få en tilfeldig retning
     * @return returnerer en tilfeldig retning
     */
    public static Retning randomDirection() {
        return values()[(int) (Math.random() * values().length)];
    }
}

