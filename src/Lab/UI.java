package Lab;

import Lab.Maze;
import Lab.Player;

import java.util.Scanner;

public class UI {
    private final Scanner sc = new Scanner(System.in);

    public void showHeader() {
        System.out.println("=== EL LABERINTO DEL PROGRAMADOR ===");
        System.out.println("Llega a la salida antes de quedarte sin energía.");
    }

    public void showStatus(Player player, Maze maze) {
        System.out.printf("%n📍 Pasos: %d/%d  | ⚡ Energía: %d%n",
                player.getSteps(), maze.getExitDistance(), player.getEnergy());
    }

    public void showMenu() {
        System.out.println("1. Avanzar");
        System.out.println("2. Girar a la izquierda");
        System.out.println("3. Girar a la derecha");
        System.out.println("4. Descansar");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    public int readOption() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresá un número: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public void showMessage(String msg) { System.out.println(msg); }

    public void showResult(Player player, Maze maze) {
        System.out.println("\n=== FIN ===");
        if (maze.hasReachedExit(player))
            System.out.println("🏆 ¡Ganaste! Salida encontrada con " + player.getEnergy() + " de energía.");
        else if (!player.isAlive())
            System.out.println("💀 Sin energía. Perdiste.");
        else
            System.out.println("👋 Saliste del juego.");
    }

    public void close() { sc.close(); }
}