package entidades;

import java.util.Random;

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
		Random rn = new Random();
		// 25 % de posibilidades de golpe critico
		int critico = rn.nextInt(4)+1;
		if (critico == 1) {
			this.setDanio(danio*2);
			System.out.println("va a ejecutar un golpe crítico");
		}
		
		System.out.println("Usando el arma Espada con "+ this.getDanio() + " pts de daño");
		return this.getDanio();
	}


}
