package entidades;

public class Espada extends Arma {

	private int danio;

	// Cada arma hace un daño especifico
	public Espada(int danio) {
		this.danio=danio;
	}
	
	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	@Override
	public int usar() {
		System.out.println("Usando el arma Espada con "+ this.getDanio() + " pts de daño");
		return this.getDanio();
	}


}
