package repoblacion.modelo;


import org.iesalandalus.programacion.utilidades.Entrada;



public class Bosque {
public int MAX_ALTURA=500;
public static int MINIMO=10;
public static int MAX_ANCHURA=1000;
private Arbol arbolMasAlejado;
private Arbol arbolMasCentrado;
private Arbol[] arboles;
private int ancho=0;
private int alto=0;
public int MAX_ESPECIES= 4;



public Bosque(int ancho, int alto, int poblacion) {
	setAncho(ancho);
	setAlto(alto);
	checkPoblacion(poblacion) ;
	arboles = new Arbol[poblacion];
	repoblar();
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
	
	
		Arbol[] bosqueDuplicado = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length; i++) {
			bosqueDuplicado[i] = new Arbol(bosqueDuplicado[i]);
		}
		return bosqueDuplicado;
	}


public int checkPoblacion(int poblacion) {
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
	Especie[]maxEspe=new Especie[MAX_ESPECIES];
	int indiAleaMax = (int)Math.random()+maxEspe.length;
	Especie espAleaMax = maxEspe[indiAleaMax];
	for (int i=0;i<MAX_ESPECIES;i++) {
		maxEspe[i]=especieAleatoria;
	}
	for (int i=0;i<MAX_ESPECIES;i++)
		while (maxEspe[i].equals(maxEspe[i-1]) || maxEspe[i].equals(maxEspe[i-2]) || maxEspe[i].equals(maxEspe[i-3]))
		{
			 maxEspe[i]=especieAleatoria;
		}
	return espAleaMax;
}

private Posicion generarPosicion() {
	
	double valX = Math.random()*ancho-(ancho/2);
	double valY = Math.random()*alto-(alto/2);
	
	Posicion posicionAleat = new Posicion(valX,valY);
	return posicionAleat;
	
}

private void repoblar() {
	for (int i=0;i<arboles.length;i++){
	Especie nuevaEspecie =generarEspecie();
	Posicion nuevaPosicion = generarPosicion();
	
	if (arboles[i-1].getEspecie()==(Especie.ALAMO))
		while (nuevaEspecie==(Especie.CASTANO) || nuevaEspecie==(Especie.CIPRES) || nuevaEspecie==(Especie.OLIVO))
			nuevaEspecie = generarEspecie();
	arboles[i] = new Arbol(nuevaPosicion,nuevaEspecie); 
	
	
	}
	}
	
public void realizarCalculos() {
	double distAnte;
	double distPost;
	for (int i=1;i<arboles.length;i++) {
		
	distAnte = Posicion.distancia(arboles[i-1].getPosicion());
	distPost = Posicion.distancia(arboles[i].getPosicion());
	
	if(distAnte >= distPost) {
		arbolMasCentrado=arboles[i];
	}
	if(distAnte <= distPost) {
		arbolMasAlejado=arboles[i];
	}
	}
	
}


}

