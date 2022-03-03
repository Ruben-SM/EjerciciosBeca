
public class Resta {

	private static int acc=0;
	
	public static int res(int a, int b) {
		return a - b;
	}
	
	public static int res(int a) {
		return acc-=a;
	}
	
	public static void main(String[] args) {
		System.out.println("la resta de 2 y 1 es: "+res(2,1));
		System.out.println("le quito 2 y tengo: "+res(2));
		System.out.println("le quito 3 y tengo: "+res(3));
	}

}