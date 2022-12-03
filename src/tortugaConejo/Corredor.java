package tortugaConejo;

public class Corredor extends Thread {

	private String corredor;
	private int velocidad;

	public Corredor(String corredor) {
		this.corredor = corredor;

		if (corredor.equals("Tortuga")) {
			velocidad = 5000; // milisegundos
		} else if (corredor.equals("Conejo")) {
			velocidad = 1000; // milisegundos
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

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

} // fin corredor
