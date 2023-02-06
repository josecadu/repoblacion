package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int anchura  =Consola.leerAnchura();
		 int altura=Consola.leerAltura();
		 int poblacion =Consola.leePoblacion();
		bosque = new Bosque(anchura, altura,poblacion);
	}

	private static Bosque bosque;
}
