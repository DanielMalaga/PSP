package tortugaConejo;

public class Carrera {
	public static int distancia = 10;

	public static void main(String[] args) {
		Corredor tortuga = new Corredor("Tortuga");
		Corredor conejo = new Corredor("Conejo");
		tortuga.start();
		conejo.start();

		// espero a que ambos corredores terminen para terminar la carrera
		try {
			tortuga.join();
			conejo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// hasta q no terminan ambos corredores su ejecución no continuo

		System.out.println("LA CARRERA ENTRE " + tortuga.getCorredor() + " Y " + conejo.getCorredor() + " HA TERMINADO");

	} // fin main

} // fin Carrera
