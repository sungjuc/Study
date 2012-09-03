package rec.r01;

public class ImmutableString {
	public static void main(String[] args) {
		String one = "Hello";
		String two = "Hello";

		if (one == two)
			System.out.println("Bob");
		if (one.equals(two))
			System.out.println("Cat");

		String three = new String("Hello");
		String four = new String("Hello");

		if (three == four)
			System.out.println("Tree");
		if (three.equals(four))
			System.out.println("Boat");
	}
}
