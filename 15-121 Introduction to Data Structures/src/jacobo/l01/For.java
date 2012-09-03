package jacobo.l01;

public class For {
	public static void main(String[] args) {
		int x;
		for (x = 0; x <= 10; x++) {
			System.out.println(x);
		}

		for (x = 0; x <= 10; x = x + 1) {
			System.out.println(x);
		}
	}
}
