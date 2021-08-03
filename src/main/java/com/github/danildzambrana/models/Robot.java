package com.github.danildzambrana.models;

public class Robot {
    private String name;
    private String brand;
    private String serial;
    private String color;

    private final String[] greetings = new String[]{
            "Hola %s un gusto saludarte!",
            "Hey %s, hoy es un dia genial!",
            "Saludar a %s como robot yo debo, bi bi bi bup",
            "Oye %s, que genial es hablar contigo!"
    };
    private boolean on = false;

    public Robot(String name, String brand, String serial, String color) {
        this.name = name;
        this.brand = brand;
        this.serial = serial;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOn() {
        return on;
    }

    /**
     *
     */
    public void turnOn() {
        System.out.println("+====================================+\n"
                + "Encendiendo. \n"
                + "Encendiendo.. \n"
                + "Encendiendo... \n"
                + "Encendido completado!\n"
                + "+====================================+\n");
        this.on = true;
    }

    /**
     * Print random greeting from greetings array.
     *
     * @param target The name of target to print.
     */
    public void greet(String target) {
        int index = (int) (Math.random() * greetings.length);
        System.out.printf(greetings[index] + "\n", target);
    }

    /**
     * Print move message with provided direction.
     *
     * @param direction
     */
    public void moveAlong(Direction direction) {
        System.out.println(direction.getValue());
    }

    /**
     * Turn off the robot.
     */
    public void turnOff() {
        System.out.println("Apagando...");
        this.on = false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre : '").append(name).append('\'').append("\n");
        sb.append("Marca: '").append(brand).append('\'').append("\n");
        sb.append("Serie : '").append(serial).append('\'').append("\n");
        sb.append("Color : '").append(color).append('\'').append("\n");
        return sb.toString();
    }
}
