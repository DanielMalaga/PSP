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
			if (((i + 1) % 10) == 0) {
				System.out.println();
			}
		}

		// tantos trozos como procesadores
		int longTrozo = cadena.length / numProcesadores;
		System.out.println(
				"numero de trozos: " + numProcesadores + ", longitud de cada trozo menos el ultimo: " + longTrozo);

		for (int i = 0; i < (numProcesadores - 1); i++) { // genero tantos arrays como procesadores menos el último.
			String subArray = "subArray".concat(String.valueOf(i));
			int[] subArray = new int[longTrozo];
		}

	} // fin main

} // fin OrdenaArrayPar
