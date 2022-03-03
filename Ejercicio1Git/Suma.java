
public class Suma {
	
	private static int acc = 0;
	
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static int sum(int a) {
		return acc+=a;
	}


}