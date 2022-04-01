package mainEJ16;

import java.util.Scanner;

import primo.Primo;

public class MainEJ16 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduzca el primer numero");
		int n1 = sc.nextInt();
		System.out.println("introduzca el segundo numero");
		int n2 = sc.nextInt();
		System.out.println("introduzca el tercer numero");
		int n3 = sc.nextInt();
		
		sc.close();
		
		Primo h1 = new Primo(n1);
		Primo h2 = new Primo(n2);
		Primo h3 = new Primo(n3);

		System.out.print("el primer numero ");
		h1.start();
		Thread.sleep(500);
		
		System.out.print("el segundo numero ");
		h2.start();
		Thread.sleep(500);
		
		System.out.print("el tercer numero "); 
		h3.start();
		
		
	}

}
