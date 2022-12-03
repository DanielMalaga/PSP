package tortugaConejo;

public class Carrera {
	public static int distancia = 10;
	private Corredor corredor1;
	private Corredor corredor2;

	public Carrera(String corr1, String corr2) {
		corredor1 = new Corredor(corr1);
		corredor2 = new Corredor(corr2);
	}

	public void empiezaCarrera(String tipoCarrera) {
		if (tipoCarrera.equals("normal")) {
			corredor1.start();
			corredor2.start();
			try {
				corredor1.join();
				corredor2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carrera " + tipoCarrera + " entre " + corredor1.getCorredor() + " Y "
					+ corredor2.getCorredor() + " ha terminado");

		} else if (tipoCarrera.equals("conejoEspera")) {
			corredor1.start();
			try {
				corredor1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			corredor2.start();
			try {
				corredor2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carrera " + tipoCarrera + " entre " + corredor1.getCorredor() + " Y "
					+ corredor2.getCorredor() + " ha terminado");
		} else {
			System.out.println("Error en tipo de Carrera");
		}
	}

	public static void main(String[] args) {

		Carrera carrera1 = new Carrera("Tortuga", "Conejo");
		carrera1.empiezaCarrera("normal");

		Carrera carrera2 = new Carrera("Tortuga", "Conejo");
		carrera2.empiezaCarrera("conejoEspera");
	} // fin main

} // fin Carrera
