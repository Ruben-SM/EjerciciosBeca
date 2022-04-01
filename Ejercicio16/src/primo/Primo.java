package primo;

public class Primo extends Thread {
	
	private int numero;
	
	public Primo(int n) {
		this.numero = n;
	}
	
	public boolean esPrimo(int numero) {
	  if (numero <= 0 || numero == 1 || numero == 4) {	// Los negativos, el 0, 1 y 4 no son primos
		    return false;
		  }
		  for (int x = 2; x < numero / 2; x++) {	// Si es divisible por cualquiera de estos números, no es primo
		    if (numero % x == 0)
		      return false;
		  }
		  return true;		// Si no se pudo dividir por ninguno de los de arriba, sí es primo
	}
	
	@Override
	public void run() {
		
		if (esPrimo(numero))
			System.out.println("es primo");
		else
			System.out.println("no es primo");
	}
}
