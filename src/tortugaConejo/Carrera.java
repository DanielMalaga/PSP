package tortugaConejo;

public class Carrera {
	public static final int distancia = 10;
	private Corredor corredor1;
	private Corredor corredor2;

	public Carrera(String corredor1, String corredor2) {
		this.corredor1 = new Corredor(corredor1);
		this.corredor2 = new Corredor(corredor2);
		this.corredor1.start();
		this.corredor2.start();
		try {
			this.corredor1.join();
			this.corredor2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("LA CARRERA HA TERMINADO");
	}

	

	public static void main(String[] args) {
		Carrera carrera = new Carrera("Tortuga", "Conejo");
	} // fin main

} // fin Carrera
