package Lab;

import java.util.Scanner;

public class UI {
    private final Scanner sc = new Scanner(System.in);

    public void showHeader() {
        System.out.println("WELCOME TO EL LABERINTO DEL PROGRAMADOR ===");
        System.out.println("Llega a la salida antes de quedarte sin energía.");
    }

    public void showStatus(Player player, Maze maze) {
        System.out.printf(
                "%n Pasos: %d/%d  | ⚡ Energía: %d%n",
                player.getSteps(),
                maze.getExitDistance(),
                player.getEnergy()
        );
    }

    public void showMenu() {
        System.out.println("1. Avanzar");
        System.out.println("2. Girar a la izquierda");
        System.out.println("3. Girar a la derecha");
        System.out.println("4. Descansar");
        System.out.println("5. Salir");
        System.out.print("Opcion: ");
    }

    public int readOption() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un numero: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public void showResult(Player player, Maze maze) {
        System.out.println("\nFIN");
        if (maze.hasReachedExit(player))
            System.out.println("Ganaste! Salida encontrada con " + player.getEnergy() + " de energia.");
        else if (!player.isAlive())
            System.out.println("Sin energia. Perdiste.");
        else
            System.out.println("Saliste del juego.");
    }

    public void close() { sc.close(); }
}