package es.videojuego.main;

import es.videojuego.modelo.entidad.Arco;
import es.videojuego.modelo.entidad.Curandero;
import es.videojuego.modelo.entidad.Espada;
import es.videojuego.modelo.entidad.Guerrero;
import es.videojuego.modelo.entidad.Hechizo;
import es.videojuego.modelo.entidad.Jefe;
import es.videojuego.modelo.entidad.Mago;
import es.videojuego.modelo.entidad.Rezo;
import es.videojuego.modelo.negocio.Fortaleza;

public class MainJefe {

	public static void main(String[] args) {
		
		Mago mago = new Mago();
		mago.setInteligencia(10);
		mago.setNombre("Gandalf");
		mago.setVida(50);
		
		Hechizo bolaDeFuego = new Hechizo();
		bolaDeFuego.setDanioMinimo(10);
		bolaDeFuego.setDanioMaximo(20);
		bolaDeFuego.setPorcentajeCritico(20);
		bolaDeFuego.setPoderHechizo(10);
		
		//ahora viene la bidercionalidad
		mago.setArma(bolaDeFuego);
		bolaDeFuego.setPersonaje(mago);
				
		Curandero cu = new Curandero();
		cu.setNombre("Saruman");
		cu.setSabiduria(10);
		cu.setVida(50);
		
		Rezo rezo = new Rezo();
		rezo.setDanioMaximo(20);
		rezo.setDanioMinimo(10);
		rezo.setPorcentajeCritico(20);
		rezo.setPoderCuracion(10);
		
		//ahora viene la bidercionalidad
		cu.setArma(rezo);
		rezo.setPersonaje(cu);
		
		
		Guerrero gue = new Guerrero();
		gue.setNombre("Warrior");
		gue.setFuerza(10);
		gue.setVida(50);
		
		Arco arco = new Arco();
		arco.setDanioMinimo(10);
		arco.setDanioMaximo(20);
		arco.setPorcentajeCritico(50);
		
		gue.setArma(arco);
		arco.setPersonaje(gue);
		
		
		
		Jefe jefe = new Jefe();
		jefe.setNombre("dragón rojo");
		jefe.setFuerza(100);
		jefe.setVida(300);
		
		Espada espada = new Espada();
		espada.setDanioMinimo(10);
		espada.setDanioMaximo(20);
		espada.setPorcentajeCritico(10);
		
		jefe.setArma(espada);
		espada.setPersonaje(jefe);
				
		Fortaleza fortaleza = new Fortaleza("Fortaleza",jefe);
		
		mago.setBatalla(fortaleza);
		Thread t1 = new Thread(mago);
		
		cu.setBatalla(fortaleza);
		Thread t2 = new Thread(cu);
		
		gue.setBatalla(fortaleza);
		Thread t3 = new Thread(gue);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
