package tortugaConejo;

public class Carrera {
	private static final int distancia = 10;
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

	public class Corredor extends Thread {

		private String corredor;
		private int velocidad;

		public Corredor(String corredor) {
			this.corredor = corredor;

			if (corredor.equals("Tortuga")) {
				velocidad = 1000;
			} else if (corredor.equals("Conejo")) {
				velocidad = 500;
			} else {
				System.out.println("error en el corredor");
			}
		}

		public void run() {

			System.out.println(corredor + " comienza carrera");

			try {
				for (int posicion = 1; posicion < (distancia + 1); posicion++) {
					Thread.sleep(velocidad);
					System.out.println(corredor + " va por " + posicion + " de la carrera");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(corredor + " finaliza la carrera");
		} // fin run

	} // fin corredor

	public static void main(String[] args) {
		Carrera carrera = new Carrera("Tortuga", "Conejo");
	} // fin main

} // fin Carrera
