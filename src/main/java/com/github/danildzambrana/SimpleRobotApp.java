package com.github.danildzambrana;

import com.github.danildzambrana.models.Direction;
import com.github.danildzambrana.models.Robot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleRobotApp {
    public static void main(String[] args) {
        SimpleRobotApp app = new SimpleRobotApp();
        Scanner in = new Scanner(System.in);
        Robot robot = app.createRobot(in);
        robot.turnOn();
        app.printMenu();

        do {
            System.out.println("Siguiente opción: ");
            int option = -1;
            while (option < 0) {
                try {
                    option = in.nextInt();
                    in = app.clearScanner();

                    if (option > 3) {
                        System.out.println("Opción no valida");
                        option = -1;
                        System.out.println("Siguiente opción: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes registrar un numero!");
                    option = -1;
                    in = app.clearScanner();
                    System.out.println("Siguiente opción: ");
                }
            }

            switch (option) {
                case 1:
                    System.out.println("Ingresa tu nombre por favor");
                    robot.greet(in.nextLine());
                    break;
                case 2:
                    app.printDirectionMenu();
                    int direction = -1;
                    while (direction < 0) {
                        try {
                            direction = in.nextInt();

                            if (direction > 5) {
                                System.out.println("Opción no valida");
                                direction = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debes registrar un numero!");
                        }
                    }
                    Direction to = null;
                    switch (direction) {
                        case 1:
                            to = Direction.FORWARD;
                            break;
                        case 2:
                            to = Direction.BACKWARDS;
                            break;
                        case 3:
                            to = Direction.TURN_LEFT;
                            break;
                        case 4:
                            to = Direction.TURN_RIGHT;
                            break;
                        case 5:
                            System.out.println("Cancelado");
                            break;
                    }

                    if (to == null) {
                        break;
                    }

                    robot.moveAlong(to);
                    break;
                case 3:
                    robot.turnOff();
            }
            in = app.clearScanner();
        } while (robot.isOn());
    }

    private Scanner clearScanner() {
        Scanner in;
        in = new Scanner(System.in);
        return in;
    }

    private void printDirectionMenu() {
        System.out.println("Seleccione la opción escribiendo el numero correspondiente\n"
                + "1) Adelante\n"
                + "2) Atrás\n"
                + "3) Girar izquierda\n"
                + "4) Girar derecha\n"
                + "5) Cancelar");
    }

    private Robot createRobot(Scanner scanner) {
        System.out.println("Fabrica de robots");
        System.out.println("Por favor ingrese un nombre para el robot. (Valor por defecto: Raul)");
        String name = scanner.nextLine();
        name = (name.isEmpty()) ? "Raul" : name;


        System.out.println("Ingrese la marca del robot. (Valor por defecto: RoboticsTM)");
        String brand = scanner.nextLine();
        brand = (brand.isEmpty()) ? "RoboticsTM" : brand;

        System.out.println("Ingrese el color. (Valor por defecto: Gris Metálico)");
        String color = scanner.nextLine();
        color = (color.isEmpty()) ? "Gris Metálico" : color;

        System.out.println("Generando robot!");
        Robot robot = new Robot(name, brand, generateSerial(), color);

        System.out.println("Robot generado con exito!: \n" + robot);
        return robot;
    }

    private String generateSerial() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            builder.append((int) (Math.random() * 9));
        }

        return builder.toString();
    }

    private void printMenu() {
        System.out.println(
                "=====================================================\n"
                        + "+=-Menu-=+ \n"
                        + "Seleccione la opción escribiendo el numero correspondiente\n"
                        + "1) Saludar\n"
                        + "2) Avanzar\n"
                        + "3) Apagar\n"
                        + "=====================================================\n"
        );
    }
}
