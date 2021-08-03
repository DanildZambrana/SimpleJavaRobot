package com.github.danildzambrana.models;

public enum Direction {
    FORWARD("Moviéndose adelante"),
    BACKWARDS("Moviéndose Atrás"),
    TURN_LEFT("Girando a la izquierda"),
    TURN_RIGHT("Girado a la derecha");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
