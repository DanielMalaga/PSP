package tortugaConejo;

public class Carrera {
	public static int distancia = 10;
	private Corredor corredor1;
	private Corredor corredor2;

	public Carrera(String corredor1, String corredor2, int dist) {
		this.corredor1 = new Corredor(corredor1);
		this.corredor2 = new Corredor(corredor2);
		distancia = dist;
		this.corredor1.start();
		this.corredor2.start();

		// espero a que ambos corredores terminen para terminar la carrera
		try {
			this.corredor1.join();
			this.corredor2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// hasta q no terminan ambos corredores su ejecución no continuo
		System.out.println("LA CARRERA ENTRE " + corredor1 + " Y " + corredor2 + " HA TERMINADO");
	}

	public static void main(String[] args) {
		Carrera carrera = new Carrera("Tortuga", "Conejo", 10);
	} // fin main

} // fin Carrera
