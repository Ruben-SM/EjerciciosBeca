package entidades;

public class Jefe extends Empleado {

	private Incentivos incentivos;
	
	public Jefe(String nombre, double sueldoBase) {
		super(nombre, sueldoBase);
	}


	public Incentivos getIncentivos() {
		return incentivos;
	}


	public void setIncentivos(Incentivos incentivos) {
		this.incentivos = incentivos;
	}


	@Override
	public double calcularSueldoFinal() {
		return this.sueldoBase + this.incentivos.getCantidad();
	}

}
