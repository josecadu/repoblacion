package repoblacion.modelo;

public class Arbol {
private Posicion posicion;
private Especie especie;

public Arbol (Posicion posicion, Especie especie) {
setPosicion(posicion);
setEspecie(especie);
}
public Arbol (Arbol a) {
	if (a ==null)
		throw new NullPointerException();
			
	setPosicion(a.getPosicion());
	setEspecie(a.getEspecie());
}

public Posicion getPosicion() {
	return posicion;
}

public void setPosicion(Posicion posicion) {
	if(posicion==null)
		throw new NullPointerException("ERROR: La posicion no puede ser nula");
	this.posicion = posicion;
}

public Especie getEspecie() {
	return especie;
}

public void setEspecie(Especie especie) {
	if(especie==null)
		throw new NullPointerException("ERROR: La especie no puede ser nula");
	this.especie = especie;
}
@Override
public String toString() {
	return "Arbol [posicion=" + posicion + ", especie=" + especie + "]";
}

}
