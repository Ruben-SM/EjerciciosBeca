package entidades;

public class Trabajador extends Empleado{

	private int valoracion;
	
	public Trabajador(String nombre, double sueldoBase) {
		super(nombre, sueldoBase);
		this.valoracion = 0;
	}

	
	public int getValoracion() {
		return valoracion;
	}


	public void setValoracion(int valoracion) {
		if (valoracion >=0 && valoracion <=10)
			this.valoracion = valoracion;
		else
			this.valoracion = 0;
	}


	@Override
	public double calcularSueldoFinal() {
		double val = 0;
		if (this.valoracion <=4) {
			val = 0;
		}else if (this.valoracion <=6) {
			val = 50;
		}else if (this.valoracion <=8) {
			val = 100;
		}else if (this.valoracion <=10){
			val = 200;
		}

		return this.sueldoBase + val;
	}

}
