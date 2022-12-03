package tortugaConejo;

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
			for (int posicion = 1; posicion < (Carrera.distancia + 1); posicion++) {
				Thread.sleep(velocidad);
				System.out.println(corredor + " va por " + posicion + " de la carrera.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(corredor + " finaliza la carrera");
	} // fin run

} // fin corredor
