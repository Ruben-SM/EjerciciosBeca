
public class Suma {
	
	private static int acc = 0;
	
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static int sum(int a) {
		return acc+=a;
	}

	public static void main(String[] args) {
		System.out.println("la suma de 1 y 2 es: "+sum(1,2));
		System.out.println("le añado 2 y tengo: "+sum(2));
		System.out.println("le añado 3 y tengo: "+sum(3));
	}

}