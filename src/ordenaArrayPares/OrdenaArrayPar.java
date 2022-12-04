package ordenaArrayPares;

import java.util.ArrayList;

// Escribir un programa que utilice Threads, al cual se le proporcione como entrada un array de tamaño aleatorio de números enteros (entre el 1 y el 100), 
// y que nos devuelva un array con los números pares de ese array ordenados de menor a mayor. 

public class OrdenaArrayPar extends Thread {

	// atributos comunes a todas las instancias de la clase
	private static int tamanoArray; // no viene determinado de entrada
	private static int[] cadena; // tampoco viene determinado hasta no saber el tamaño del Array
	private static ArrayList<Integer> cadenaPares = new ArrayList<Integer>();
	private static Object bloqueo = new Object(); // objeto usado para sincronizar el acceso al ArrayList

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
				}

			}
		}

	}

	public static void main(String[] args) {

		OrdenaArrayPar.tamanoArray = 80000;
		OrdenaArrayPar.cadena = new int[tamanoArray];

		// genero el array y lo relleno de int [1..100] longitud: tamanoArray uds.
		int totalParesEnCadena = 0;
		for (int i = 0; i < cadena.length; i++) {
			cadena[i] = (int) (Math.random() * 100 + 1);
			//System.out.print(cadena[i] + " ");
			if (cadena[i] % 2 == 0) {
				totalParesEnCadena++; // para comprobar el resultado sin indeterminismo.
			}
			//if (((i + 1) % 30) == 0) { // visualizo hasta 30 columnas en cada fila
			//	System.out.println();
			//}
		}
		System.out.println();
		System.out.println("el array de entrada tiene: [" + totalParesEnCadena + "] numeros pares");
		System.out.println();

		// para saber de cuantos procesadores se dispone
		Runtime ordenador = Runtime.getRuntime();
		int numProcesadores = ordenador.availableProcessors();

		// genero un array de OrdenaArrayPar de la clase de tamaño igual al núm de
		// procesadores.

		// si el array no es mayor que el núm de procesadores ni lo divido, hago un solo
		// hilo.
		if (cadena.length < numProcesadores) {
			OrdenaArrayPar trozoUnico = new OrdenaArrayPar(0, cadena.length);
			trozoUnico.start();
			try { // espero a q termine
				trozoUnico.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else { // al menos tengo igual num elem q de procesadores.

			// creo un array de objetos cuyo tamaño es igual al núm procesadores.
			OrdenaArrayPar[] grupoParaOrdenar = new OrdenaArrayPar[numProcesadores];
			int longTrozo = cadena.length / numProcesadores;

			// instancio todos los elementos del array dividiendo el array de entrada entre
			// los procesadores
			for (int i = 0; i < grupoParaOrdenar.length; i++) {
				if (i == (grupoParaOrdenar.length - 1)) { // el último hilo procesa hasta el final
					grupoParaOrdenar[i] = new OrdenaArrayPar((i * longTrozo), ((i * longTrozo) + longTrozo + (cadena.length % numProcesadores)));
				} else { // no es el último hilo
					grupoParaOrdenar[i] = new OrdenaArrayPar((i * longTrozo), ((i * longTrozo) + longTrozo));
				}
			}
			// ejecuto los hilos
			for (int i = 0; i < grupoParaOrdenar.length; i++) {
				grupoParaOrdenar[i].start();
			}

			// espero a q terminen
			try {
				for (int i = 0; i < grupoParaOrdenar.length; i++) {
					grupoParaOrdenar[i].join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ordenamos el arrayList
		cadenaPares.sort((o1, o2) -> o1.compareTo(o2)); // de menor a mayor

		// ahora pasamos el ArrayList a Array
		int[] cadenaResultado = new int[cadenaPares.size()];
		for (int i = 0; i < cadenaResultado.length; i++) {
			cadenaResultado[i] = cadenaPares.get(i);
			//System.out.print((cadenaResultado[i] + " "));
		}

		// listamos el array resultado con los números pares ordenados de menor a mayor.
		System.out.println();
		System.out.println("el array de salida tiene: [" + cadenaResultado.length + "] numeros pares");

	} // fin main

} // fin OrdenaArrayPar
