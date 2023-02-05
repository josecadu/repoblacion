package repoblacion.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.junit.jupiter.api.ClassOrderer.Random;


public class Bosque {
public int MAX_ALTURA=500;
public int MINIMO=10;
public int MAX_ANCHURA=1000;
private Arbol arbolMasAlejado;
private Arbol arbolMasCentrado;
private Arbol[] arboles;
private int ancho=0;
private int alto=0;
public int MAX_ESPECIES= 4;
private Random generador;

public Bosque(int ancho, int alto, int poblacion) {
	setAncho(ancho);
	setAlto(alto);
	poblacion=Entrada.entero() ;
	
}

public int getAncho() {
	return ancho;
}

public void setAncho(int ancho) {
	if (ancho >= MAX_ANCHURA | ancho <= MINIMO)
	throw new IllegalArgumentException("ERROR: El ancho debe ser mayor que 10 y menor que 1000");
	this.ancho = ancho;
}

public int getAlto() {
	return alto;
}

public void setAlto(int alto) {
	if (alto >= MAX_ALTURA | ancho <= MINIMO)
		throw new IllegalArgumentException("ERROR: El alto debe ser mayor que 10 y menor que 500");
	this.alto = alto;
}
public Arbol[] duplicaBosque() {
	return Arbol;
}
public int checkpoblacion(int poblacion) {
	if (poblacion > 2*(alto+ancho))
		throw new IllegalArgumentException("ERROR: La poblacion no puede superar el perimetro del bosque");
	return poblacion;
}
public Arbol getArbolMasAlejado() {
	return arbolMasAlejado;
}
public Arbol getArbolMasCentrado() {
	return arbolMasCentrado;
}

private Especie generarEspecie() {

	Especie[]especies=Especie.values();
	int indiAlea = (int)Math.random()+especies.length;
	Especie especieAleatoria = especies[indiAlea];
	return  especieAleatoria;
}

private Posicion generarPosicion() {
	
	double valX = Math.random()*ancho-(ancho/2);
	double valY = Math.random()*alto-(alto/2);
	
	Posicion posicionAleat = new Posicion(valX,valY);
	return posicionAleat;
	
}

private void repoblar() {
	for (int i=0;i<arboles.length;i++){
	Especie nuevaEspecie = generarEspecie();
	Posicion nuevaPosicion = generarPosicion();
	
	if (arboles[i-1].getEspecie()==(Especie.ALAMO))
		while (nuevaEspecie==(Especie.CASTANO) || nuevaEspecie==(Especie.CIPRES) || nuevaEspecie==(Especie.OLIVO))
			nuevaEspecie = generarEspecie();
	arboles[i] = new Arbol(nuevaPosicion,nuevaEspecie); 
	for (int j=0;j<MAX_ESPECIES;j++) {
		while ((arboles[j-1].getEspecie()!=(nuevaEspecie)) || (arboles[j-2].getEspecie()!=(nuevaEspecie)) || (arboles[j-3].getEspecie()!=(nuevaEspecie)))
				nuevaEspecie = generarEspecie();
	}
		
	}
	
	
}


}

