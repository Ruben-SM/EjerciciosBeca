package entidades;

public class Hechizo extends Arma{

	private int danio;

	public Hechizo(int danio) {
		this.danio = danio;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}


	@Override
	public int usar() {
		System.out.println("Usando el arma Hechizo con "+ this.getDanio() + " pts de daño");
		return this.getDanio();
		
	}


}
