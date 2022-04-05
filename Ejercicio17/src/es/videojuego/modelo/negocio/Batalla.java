package es.videojuego.modelo.negocio;

import java.util.List;
import java.util.Scanner;

import es.videojuego.modelo.entidad.Personaje;
import es.videojuego.util.NumeroAleatorio;

public class Batalla {
	private Personaje p1;
	private Personaje p2;

	/**
	 * Empieza una lucha entre dos personajes y devuelve el personaje
	 * vencedor
	 * @return
	 */
	public Personaje combatir() {
		Personaje pInicial = null;
		Personaje pFinal = null;
		Personaje pGanador = null;
		int turno = 1;
				
		//tiramos moneda al aire
		int moneda = NumeroAleatorio.generarNumero(1, 2);
		if(moneda == 1) {
			pInicial = p1;
			pFinal = p2;
		}else {
			pInicial = p2;
			pFinal = p1;
		}
		
		System.out.println("COMIENZA LA BATALLA POR LA LUCHA DEL MEJOR COMBATIENTE DEL REINO");
		System.out.println("Personaje Inicial: " + pInicial + " con el arma " + pInicial.getArma());
		System.out.println("Personaje Final " + pFinal + " con el arma " + pFinal.getArma());
		boolean combateAcabado = false;
		
		do {
			int danio = pInicial.atacar(pFinal);
			logBatalla(pInicial, pFinal, danio, turno);
			if(pFinal.estaMuerto()) {
				pGanador = pInicial;
				combateAcabado = true;
			}else {
				danio = pFinal.atacar(pInicial);
				logBatalla(pFinal, pInicial, danio, turno);
				if(pInicial.estaMuerto()) {
					pGanador = pFinal;
					combateAcabado = true;
				}
			}
			System.out.println(pInicial);
			System.out.println(pFinal);
			turno++;
		}while(!combateAcabado);
		
		return pGanador;
	}
	
	public void logBatalla(Personaje p1, Personaje p2, int danio, int turno) {
		System.out.println("turno: " +turno+" El personaje " 
				+ p1.getNombre() + " ha hecho " 
				+ danio + " al personaje " + p2.getNombre());
	}

	public Personaje getP1() {
		return p1;
	}


	public void setP1(Personaje p1) {
		this.p1 = p1;
	}


	public Personaje getP2() {
		return p2;
	}


	public void setP2(Personaje p2) {
		this.p2 = p2;
	}
	
}
