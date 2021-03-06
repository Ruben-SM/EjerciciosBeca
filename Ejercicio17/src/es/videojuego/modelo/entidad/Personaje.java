package es.videojuego.modelo.entidad;

import es.videojuego.modelo.negocio.Fortaleza;

public abstract class Personaje implements Runnable{
	private String nombre;
	private int vida;
	private Arma arma;
	
	private Fortaleza batalla;
	
	/**
	 * Metodo que atacamos a un persona
	 * @param p personaje al que vamos a atacar
	 * @return da?o que ha causado el arma
	 */
	public int atacar(Personaje p) {
		int danio = arma.usar();
		int vidaRestante = p.getVida() - danio;
		p.setVida(vidaRestante);
		return danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public Fortaleza getBatalla() {
		return batalla;
	}

	public void setBatalla(Fortaleza batalla) {
		this.batalla = batalla;
	}

	public boolean estaMuerto() {
		if(getVida() <= 0) {
			System.out.println(".." + this.nombre + " me muerooooooooooooo arrrggggggg........");
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vida=" + vida + "]";
	}	
	
	@Override
	public void run() {
		batalla.entrar(this);
	}
}
