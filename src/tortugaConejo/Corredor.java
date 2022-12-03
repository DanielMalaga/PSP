package tortugaConejo;

public class Corredor extends Thread {

	private String corredor; // nombre del corredor.
	private int velocidad; // velocidad de cada corredor.

	public Corredor(String corredor) { // constructor
		this.corredor = corredor;
		// dependiendo del corredor la velocidad será una u otra
		if (corredor.equals("Tortuga")) {
			velocidad = 5000; // milisegundos
		} else if (corredor.equals("Conejo")) {
			velocidad = 1000; // milisegundos
		} else { // si hay error en el corredor pasado como parámetro
			System.out.println("error en el corredor");
		}
	}

	public void run() {
		// empieza a correr el corredor.
		System.out.println(corredor + " comienza carrera");

		try {
			/*
			 * recorremos la distancia de la carrera durmiendo al corredor velocidad miliseg
			 * e indicando en cada iteración la posición en la que se encuentra.
			 */
			for (int posicion = 1; posicion < (Carrera.distancia + 1); posicion++) {
				Thread.sleep(velocidad);
				System.out.println(corredor + " va por " + posicion + " de la carrera.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// acaba la carrera el corredor
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
