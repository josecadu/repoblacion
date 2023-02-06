package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

import repoblacion.modelo.Bosque;

public class Consola {
private Consola() {
	
}
public static int leerAnchura() {
	int anchura=Entrada.entero();
	do {
		System.out.println("Introduzca la anchura entre 10 y 1000): ");
		anchura = Entrada.entero();
		
	}while (anchura < Bosque.MINIMO || anchura >= Bosque.MAX_ANCHURA);
	return anchura;
}
public static int leerAltura() {
	int altura=Entrada.entero();
	do {
		System.out.println("Introduzca la altura entre 10 y 500): ");
		altura = Entrada.entero();
		
	}while (altura < Bosque.MINIMO || altura >= Bosque.MAX_ANCHURA);
	return altura;
}
public static int leePoblacion() {
	System.out.println("Introduzca la poblacion");
	int poblacion=Entrada.entero();
	return poblacion;
}
}


