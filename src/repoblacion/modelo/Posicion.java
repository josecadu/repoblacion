package repoblacion.modelo;


public class Posicion {
private double x;
private double y;

public Posicion (double x, double y) {
	setX(x);
	setY(y);
}
public Posicion (Posicion p) {
	if (p == null)
		throw new NullPointerException("ERROR: no es posible copiar una posicion nula");
	setX ( p.getX());
	setY ( p.getY());
}

public double getX() {
	return x;
}

private void setX(double x) {
	this.x = x;
}

public double getY() {
	return y;
}

private void setY(double y) {
	this.y = y;
}
public double distancia(Posicion posicion) {
	
	if (posicion==null)
		throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
	else
	 
	return Math.sqrt(Math.pow(posicion.getX(), -this.x) + Math.pow(posicion.getY(), -this.y)) ;
}

@Override
public String toString() {
	return "Posicion [x=" + x  + ", y=" + y + "]";
}
}
