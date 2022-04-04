package entidades;

public class Curandero extends Personaje{

	private int sabiduria;

	public int getSabiduria() {
		return sabiduria;
	}

	public Curandero(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}


	@Override
	public int atacar() {
		System.out.println("el personaje "+ this.getNombre() +" va a atacar");
		if (this.getArma() instanceof Rezo) {
			System.out.println("tiene una bonificacion de " + sabiduria + " en curación");
			this.setVida( sabiduria + this.getVida());
			return this.getArma().usar()  ;
		}
		return this.getArma().usar();
		
	}


}
