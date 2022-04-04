package entidades;

public class Batalla {

	private Personaje p1;
	private Personaje p2;
	
	public Batalla(Personaje p1, Personaje p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void pelear() {
		
		// empieza a atacar siempre el personaje p1
		
		int turno = 1;
		
		int vidaP1 = p1.getVida();
		int vidaP2 = p2.getVida();
		
		int danioP1,danioP2;
		
		if (p1 == p2) {
			System.out.println("no puede pelear consigo mismo");
			return ;
		}
		
		System.out.println("################ COMIENZO DE BATALLA ########################");
		System.out.println();

		System.out.println("el personaje "+ this.p1.getNombre() + " comienza con " + vidaP1 +" HP ");
		System.out.println("el personaje "+ this.p2.getNombre() + " comienza con " + vidaP2 +" HP ");
		System.out.println();
		
		do {

			System.out.println("###############TURNO "+turno+"#########################");
			System.out.println();

			danioP1 = p1.atacar();	
			System.out.println("el personaje "+p2.getNombre() + " recibi� " + danioP1+" pts de da�o");
			vidaP2 = p2.recibirDanio(danioP1);
			System.out.println(p1.toString());
			System.out.println(p2.toString());

			
			if(vidaP2<=0)
				break;
			
			System.out.println();
		
			danioP2 =  p2.atacar();
			System.out.println("el personaje "+p1.getNombre() + " recibi� " + danioP2+" pts de da�o");
			vidaP1 = p1.recibirDanio(danioP2);
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			
			System.out.println();
			turno++;
			
		} while( vidaP1 > 0 || vidaP2 > 0);
		System.out.println();
		if (vidaP1 > 0) {
			System.out.println("el personaje "+ this.p2.getNombre() + " Muri�");
			System.out.println("Ha ganadado el personaje "+ this.p1.getNombre()+ " con " +this.p1.getVida() +" HP" );
		}else if (vidaP2 > 0) {
			System.out.println("el personaje "+ this.p1.getNombre() + " Muri�");
			System.out.println("Ha ganadado el personaje "+ this.p2.getNombre()+ " con " +this.p2.getVida() +" HP" );
		}
		System.out.println();
		System.out.println("################# FINAL DE BATALLA #######################");
		System.out.println();
	}
		
	
}
