package ejercicio18;

import java.util.Scanner;

public class ejercicio18 {
	
	private interface Primo {
		public Runnable esPrimo(Integer n);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduzca el primer numero");
		int n1 = sc.nextInt();
		System.out.println("introduzca el segundo numero");
		int n2 = sc.nextInt();
		System.out.println("introduzca el tercer numero");
		int n3 = sc.nextInt();
		
		sc.close();
		
		Primo primo = numero -> {
			boolean loEs = true;
			if (numero <= 0 || numero == 1 || numero == 4) {	// Los negativos, el 0, 1 y 4 no son primos
				loEs = false;
			  }
			  for (int x = 2; x < numero / 2; x++) {	// Si es divisible por cualquiera de estos números, no es primo
			    if (numero % x == 0)
			      loEs = false;
			  }
			  if (loEs) {
				  System.out.println(numero+" es primo");
			  }else {
				  System.out.println(numero+" no es primo");
			  }
			return null;
		};
		
		Thread t1 = new Thread(primo.esPrimo(n1));
		Thread t2 = new Thread(primo.esPrimo(n2));
		Thread t3 = new Thread(primo.esPrimo(n3));
		
		t1.start();
		t2.start();
		t3.start();

	}

}
