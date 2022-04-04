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
	
	
	/**
	 * Metodo para atacar
	 * @return el daño que produce
	 */
	
	public abstract int atacar();					
	
	
	/**
	 * 
	 * @param daño que recibe
	 * @return la vida que le queda al personaje despues de recibir golpe
	 */
	
	public int recibirDanio(int golpe) {			
		int vida = this.getVida();
		this.setVida(vida-golpe);
		vida = this.getVida();
		return vida;
		
	}
	
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vida=" + vida + "]";
	}
	
	
}
