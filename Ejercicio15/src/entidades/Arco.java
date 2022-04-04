package entidades;

public class Arco extends Arma {

	private int danio;

	public Arco(int danio) {
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
		System.out.println("Usando el arma Arco con "+ this.getDanio() + " pts de daño");
		return this.getDanio();
		
	}


}
