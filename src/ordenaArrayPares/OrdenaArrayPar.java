package ordenaArrayPares;

import java.util.ArrayList;

// Escribir un programa que utilice Threads, al cual se le proporcione como entrada un array de tamaño aleatorio de números enteros (entre el 1 y el 100), 
// y que nos devuelva un array con los números pares de ese array ordenados de menor a mayor. 

public class OrdenaArrayPar extends Thread {

	// atributos comunes a todas las instancias de la clase
	private static int tamanoArray = 100;
	private static int[] cadena = new int[tamanoArray];
	private static ArrayList<Integer> cadenaPares = new ArrayList<Integer>();
	private static Object bloqueo = new Object();
	private static int totalPares = 0;

	// atributos particulares de cada instancia.
	private int inicio;
	private int fin;

	public OrdenaArrayPar(int inicio, int fin) { // constructor
		// parámetros de entrada inicio y fin bloque q se asigna de la cadena.
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() { // ejecución de cada hilo
		// recorro el trozo definido entre inicio y fin del array común

		for (int i = inicio; i < fin; i++) {

			if (cadena[i] % 2 == 0) { // es par
				synchronized (bloqueo) {
					cadenaPares.add(cadena[i]);
					totalPares++;
				}

			}
		}

	}

	public static void main(String[] args) {

		// para saber de cuantos procesadores se dispone
		Runtime ordenador = Runtime.getRuntime();
		int numProcesadores = ordenador.availableProcessors();
		// System.out.println("Este ordenador tiene: " + numProcesadores + "
		// procesadores.");

		// genero el array y lo relleno de int [1..100] longitud: 10 uds.
		int totalParesEnCadena = 0;
		for (int i = 0; i < cadena.length; i++) {
			cadena[i] = (int) (Math.random() * 100 + 1);
			System.out.print("[" + cadena[i] + "] ");
			if (cadena[i] % 2 == 0) {
				totalParesEnCadena++;
			}
			if (((i + 1) % 30) == 0) { // visualizo hasta 30 columnas en cada fila
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("el array tiene: [" + totalParesEnCadena + "] numeros pares");
		System.out.println();
		System.out.println("** Ahora el arrayList **");

		OrdenaArrayPar trozo1 = new OrdenaArrayPar(0, 26);
		OrdenaArrayPar trozo2 = new OrdenaArrayPar(26, 51);
		OrdenaArrayPar trozo3 = new OrdenaArrayPar(51, 76);
		OrdenaArrayPar trozo4 = new OrdenaArrayPar(76, 100);
		trozo1.start();
		trozo2.start();
		trozo3.start();
		trozo4.start();

		// espero a q terminen
		try {
			trozo1.join();
			trozo2.join();
			trozo3.join();
			trozo4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ordenamos el arrayList
		//cadenaPares.sort(int);
		System.out.println();
		System.out.println("el array tiene: [" + totalPares + "] numeros pares");
		// muestro el resultado del ArrayList
		cadenaPares.forEach(number -> System.out.print("[" + number + "] "));
		System.out.println();
		System.out.println("el ArrayList tiene: [" + cadenaPares.size() + "] numeros q son pares");
		


	} // fin main

} // fin OrdenaArrayPar
