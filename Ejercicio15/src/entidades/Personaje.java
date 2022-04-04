package entidades;

public abstract class Personaje {

	private String nombre;
	private Arma arma;
	private int vida;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public abstract int atacar();					// devuelve el daño que produce
	
	public int recibirDanio(int golpe) {			// devuelve la vida que le queda al personaje despues de recibir golpe
		int vida = this.getVida();
		this.setVida(vida-golpe);
		vida = this.getVida();
		if (vida >0)
			System.out.println("al personaje "+ this.getNombre() + " le quedan "+ vida +" HP");
		else 
			System.out.println("al personaje "+ this.getNombre() + " le quedan 0 HP");
		return vida;
		
	}
}
