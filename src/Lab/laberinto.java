package Lab;

import java.util.Scanner;

public class laberinto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int energy = 30;
		int steps = 0;
		int exit = 5;
		int opt = 0;
		
		System.out.println("=== EL LABERINTO DEL PROGRAMADOR ===");
		System.out.println("Debes llegar a la salida antes de quedarte sin energia");
		
		while (energy > 0 && steps < exit && opt != 5) {
			System.out.println();
			System.out.println("Elige una opcion: ");
			System.out.println("1. Avanzar");
			System.out.println("2. Girar a la izq");
			System.out.println("3. Girar a la der");
			System.out.println("4. Ver energia");
			System.out.println("5. Salir del juego");
			System.out.println("6. Borrar la cuenta");
			System.out.print("Opcion: ");
			
			opt = sc.nextInt();
			
			if (opt == 1) {
				steps += 1;
				energy -= 5;
				
				System.out.println("Avanzaste un paso.");
			} else if (opt == 2) {
				energy -= 2;
				System.out.println("Giraste a la izq.");
			} else if (opt == 3) {
				System.out.println("Giraste a la der.");
			} else if (opt == 4) {
				System.out.println("Tu energia actual es: " + energy);
			} else if (opt == 5) {
				System.out.println("Saliste del juego.");
			} else if (opt == 6) {
				System.out.println("Borrando System32...");
			} else {
				System.out.println("Opcion incorrecta. Pierdes 1 de energia.");
				energy -= 1;
			}
		}
		
		System.out.println();
		
		if (steps >= exit) {
			System.out.println("¡Ganaste! Encontraste la salida del laberinto");
		} else if (energy <= 0) {
			System.out.println("Perdiste. Te quedaste sin energia.");
		} else {
			System.out.println("Juego finalizado.");
		}
		
		sc.close();
	}
}
