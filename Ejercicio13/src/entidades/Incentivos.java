package entidades;

public enum Incentivos {
	BONOS(500), COMISIONES(300), MERITOS(700);

	private double cantidad;
	
	private Incentivos(double c) {
		this.cantidad = c; 
	}

	public double getCantidad() {
		return cantidad;
	}
	
	
	
	
	
	
}
