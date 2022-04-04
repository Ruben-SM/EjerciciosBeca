package entidades;

public class Guerrero extends Personaje{
	
	private int fuerza;
	
	public Guerrero(int fuerza) {
		this.fuerza = fuerza;
	}


	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}



	@Override
	public int atacar() {
		System.out.println("el personaje "+this.getNombre() +" va a atacar");
		if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			System.out.println("tiene una bonificacion de " + fuerza + " en ataque");
			return this.getArma().usar() + fuerza ;
		}
		return this.getArma().usar();
	}

}
