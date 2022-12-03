package tortugaConejo;

public class Carrera {
	// atributos
	public static final int distancia = 10; // común a todas las carreras y constante.

	private Corredor corredor1; // corredor1 de la instancia carrera generada
	private Corredor corredor2; // corredor2 de la instancia carrera generada

	public Carrera(String corr1, String corr2) { // constructor
		corredor1 = new Corredor(corr1);
		corredor2 = new Corredor(corr2);
	}

	public void empiezaCarrera(String tipoCarrera) {

		if (tipoCarrera.equals("normal")) { // carrera tipo normal
			corredor1.start(); // corredores empiezan a la vez
			corredor2.start();
			try { // la instancia carrera espera a q los corredores terminen
				corredor1.join();
				corredor2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carrera " + tipoCarrera + " entre " + corredor1.getCorredor() + " Y "
					+ corredor2.getCorredor() + " ha terminado");

		} else if (tipoCarrera.equals("conejoEspera")) { // carrera tipo conejoEspera
			corredor1.start(); // empieza primero tortuga
			try { // hilo principal espera a que termine para continuar
				corredor1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // cuando hilo principal continúa una vez terminada tortuga empieza conejo.
			corredor2.start();
			try {
				corredor2.join(); // hilo principal espera a conejo para terminar toda la carrera.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carrera " + tipoCarrera + " entre " + corredor1.getCorredor() + " Y "
					+ corredor2.getCorredor() + " ha terminado");
		} else { // por si se introduce una carrera de un tipo erróneo o desconocido.
			System.out.println("Error en tipo de Carrera");
		}
	}

	public static void main(String[] args) {

		// empezamos carrera tipo normal.
		Carrera carrera1 = new Carrera("Tortuga", "Conejo");
		carrera1.empiezaCarrera("normal");

		// empezamos carrera tipo conejoEspera. Son dos instancias de carrera
		// diferentes.
		Carrera carrera2 = new Carrera("Tortuga", "Conejo");
		carrera2.empiezaCarrera("conejoEspera");
	} // fin main

} // fin Carrera
