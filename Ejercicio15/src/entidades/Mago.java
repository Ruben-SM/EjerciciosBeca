package entidades;

public class Mago extends Personaje {

	private int inteligencia;
	
	public Mago(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	
	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}



	@Override
	public int atacar() {
		System.out.println("el personaje "+this.getNombre() +" va a atacar");
		if (this.getArma() instanceof Hechizo) {
			System.out.println("tiene una bonificacion de " + inteligencia + " en ataque mágico");
			return this.getArma().usar() + inteligencia ;
		}
		return this.getArma().usar();
		
	}

}
