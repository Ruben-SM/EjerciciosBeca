package entidades;

public class Rezo extends Arma {

	private int curacion;
	
	public Rezo(int curacion) {
		this.curacion = curacion;
	}

	public int getCuracion() {
		return curacion;
	}


	public void setCuracion(int curacion) {
		this.curacion = curacion;
	}


	@Override
	public int usar() {
		System.out.println("Usando el arma rezo con "+ this.getCuracion() + " pts de salud");
		return this.getCuracion();
	}

}
