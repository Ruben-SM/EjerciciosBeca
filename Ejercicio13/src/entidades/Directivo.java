package entidades;

import java.util.ArrayList;

public class Directivo extends Empleado{
	
	private ArrayList<Empleado> empleadosACargo;

	public Directivo(String nombre, double sueldoBase) {
		super(nombre, sueldoBase);
		empleadosACargo = new ArrayList<>();
	}
	

	public ArrayList<Empleado> getEmpleadosACargo() {
		return empleadosACargo;
	}


	public void setEmpleadosACargo(ArrayList<Empleado> empleadosACargo) {
		this.empleadosACargo = empleadosACargo;
	}


	@Override
	public double calcularSueldoFinal() {
		return this.sueldoBase + (empleadosACargo.size() * 100);
	}
	

}
