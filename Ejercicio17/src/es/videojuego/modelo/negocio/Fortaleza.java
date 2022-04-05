package es.videojuego.modelo.negocio;

import es.videojuego.modelo.entidad.Jefe;
import es.videojuego.modelo.entidad.Personaje;

public class Fortaleza {

	private String nombre;
	private Jefe jefe;
	
	public Fortaleza(String nombre, Jefe jefe) {
		this.nombre = nombre;
		this.jefe = jefe;
	}
	
	
	public synchronized void entrar(Personaje personaje) {
		Personaje p = null;
		System.out.println("Ha entrado "+personaje.getNombre()+", se cierran las puertas");
		
		if (jefe.getVida() > 0) {
			Batalla b = new Batalla();
			
			b.setP1(personaje);
			b.setP2(jefe);
			
			p = b.combatir();
		}

		if(!(p instanceof Jefe) || p == null) {
			System.out.println("EL JEFE HA CAIDO");
		}
		
		if (personaje.estaMuerto()) {
			System.out.println(personaje.getNombre()+" ha muerto, se abren las puertas");
		}else {
			System.out.println("Ha salido vivo "+personaje.getNombre()+", se abren las puertas");
		}
		
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

}
