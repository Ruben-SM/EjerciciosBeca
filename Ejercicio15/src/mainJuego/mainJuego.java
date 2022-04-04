package mainJuego;

import entidades.*;

public class mainJuego {

	public static void main(String[] args) {
		
		Personaje p1 = new Guerrero(5);	// personaje con su atributo especifico correspondiente
		Personaje p2 = new Curandero(1);
		
		Arma a1 = new Espada(5);	// arma con atributo daño/curacion del arma
		Arma a2 = new Rezo(1);
		
		p1.setNombre("Guerrero1");
		p1.setVida(20);
		p1.setArma(a1);
		
		p2.setNombre("Curandero1");
		p2.setVida(20);
		p2.setArma(a2);
		
		// Pelea Guerrero vs Curandero
		Batalla b = new Batalla(p1, p2);
		b.pelear();
		
		p2 = new Mago(2);
		a2 = new Espada(5);
		
		p2.setNombre("Mago1");
		p2.setVida(15);
		p2.setArma(a2);
		
		// Pelea Guerrero vs Mago 
		b = new Batalla(p1,p2);
		b.pelear();
	}

}
