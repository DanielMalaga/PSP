package ordenaArrayPares;

import java.util.Random;

// Escribir un programa que utilice Threads, al cual se le proporcione como entrada un array de tamaño aleatorio de números enteros (entre el 1 y el 100), 
// y que nos devuelva un array con los números pares de ese array ordenados de menor a mayor. 

public class OrdenaArrayPar {

	public OrdenaArrayPar(int cadenaNum[], int procesadores) { // constructor

	}

	public static void main(String[] args) {

		// para saber de cuantos procesadores se dispone
		Runtime ordenador = Runtime.getRuntime();
		int numProcesadores = ordenador.availableProcessors();
		System.out.println("Este ordenador tiene: " + numProcesadores + " procesadores.");

		// genero el array y lo relleno de int [1..100] longitud: 100 uds.
		int[] cadena = new int[100];
		for (int i = 0; i < cadena.length; i++) {
			cadena[i] = (int) (Math.random() * 100 + 1);
			System.out.print("[" + cadena[i] + "] ");
			if (((i + 1) % 10) == 0) { // visualizo 10 columnas en cada fila
				System.out.println();
			}
		}

		System.out.println();

		// lo recorro y el q no sea par lo pongo a -1
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i] % 2 != 0) {
				cadena[i] = -1;
			}
			System.out.print("[" + cadena[i] + "] ");
			if (((i + 1) % 10) == 0) {
				System.out.println();
			}
		}

		// divido array en tantos trozos como procesadores tengo.
		// la longitud de cada trozo es el tam total entre el num proc.
		int longTrozo = cadena.length / numProcesadores;

		System.out.println("num trozos: " + numProcesadores + ", longitud de cada trozo menos el ultimo: " + longTrozo);
		System.out.println("long último trozo: " + (longTrozo + (cadena.length % numProcesadores)));

	} // fin main

} // fin OrdenaArrayPar
