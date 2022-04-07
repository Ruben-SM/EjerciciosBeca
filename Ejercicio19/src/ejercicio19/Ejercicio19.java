package ejercicio19;

public class Ejercicio19<E> {
	
	public interface Operaciones<E>{
		
		public E operar(E x, E y);
	}

	public static void main(String[] args) {
		Operaciones<Integer> sumar = (a,b) -> a+b;
		Operaciones<Integer> restar = (a,b) -> a-b;
		Operaciones<Integer> multiplicar = (a,b) -> a*b;
		Operaciones<Integer> dividir = (a,b) -> a/b;
		
		int n1 = 5;
		int n2 = 4;
		
		System.out.println("suma: "+ sumar.operar(n1, n2));
		System.out.println("resta"+ restar.operar(n1, n2));
		System.out.println("multiplicacion"+ multiplicar.operar(n1, n2));
		System.out.println("division"+ dividir.operar(n1, n2));

	}

}
