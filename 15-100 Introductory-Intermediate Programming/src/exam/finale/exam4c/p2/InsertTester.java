package exam.finale.exam4c.p2;

import exam.finale.exam4c.p1.Stamp;

public class InsertTester {
	public static void main(String[] args) {
		StampList test = new StampList();

		load(test); // this method is provided for you to load the SList
		System.out.println("Initial data loaded into StampList...\n" + test);
		System.out.println();

		testInsert(test);
	}

	private static void testInsert(StampList test) {
		System.out.println("\nINSERTION TESTS...\n");

		Stamp s1 = new Stamp("T. Roosevelt (US 1940)", 1, 35.40);
		System.out.println("Insert at index 4 of " + s1);
		test.insert(s1, 4);
		System.out.println(test);
		System.out.println();

		Stamp s2 = new Stamp("LOVE (US 1975)", 31, 0.35);
		System.out.println("Insert at index 6 of " + s2);
		test.insert(s2, 6);
		System.out.println("Insert at index -5 of " + s2);
		test.insert(s2, -5);

		System.out.println();

		System.out.println("Insert at index 2 of " + s2);
		test.insert(s2, 2);
		System.out.println(test);
		System.out.println();

		Stamp s3 = new Stamp("Elizabeth II (GB 1950)", 10, 18.45);
		System.out.println("Insert at index 0 of " + s3);
		test.insert(s3, 0);
		System.out.println(test);
		System.out.println();

	}

	public static void load(StampList a) {
		a.insertAtEnd(new Stamp("Liberty (US 1955)", 5, 20.0));
		a.insertAtEnd(new Stamp("Lincoln (US 1940)", 3, 15.05));
		a.insertAtEnd(new Stamp("Blue Loon (Can 1970)", 25, 10.5));
		a.insertAtEnd(new Stamp("Young Elvis (US 1995)", 33, 1.35));
	}
}
