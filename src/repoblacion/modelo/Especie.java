package repoblacion.modelo;

public enum Especie {
ALAMO("álamo"),ENCINA("emcina"),CASTANO("castaño"),CIPRES("ciprés"),
PINO("pino piñonero"),ROBLE("roble mediterráneo"),OLIVO("olivo");	
	
	private String cadenaAMostrar;
	
	private Especie(String cadenaAMostrar) {
		
		this.cadenaAMostrar=cadenaAMostrar;
	}

	public String getCadenaAMostrar() {
		return cadenaAMostrar;
	}

	public void setCadenaAMostrar(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
		
	}
	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}

