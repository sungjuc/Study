package exam.finale.exam4c.p1;

/* This class is the test program for the first problem of exam 4.
 The first problem will show your ability to write a (very) simple class.

 You should not change any code in this class.

 */
public class StampTester {
	public static void main(String[] args) {
		System.out.println("Creating two stamps...\n");
		Stamp stamp1 = new Stamp("Kennedy (US 1963)", 5, 0.60);
		Stamp stamp2 = new Stamp("Lincoln (US 1923)", 1, 42.60);

		System.out.println("\nPrinting them...");
		System.out.println(stamp1);
		System.out.println(stamp2);

		System.out.println("\nChanging some values");
		System.out.println("Changing the appraisal of "
				+ stamp1.getDescription() + " from "
				+ stamp1.getAppraisedValue() + " dollars");
		stamp1.setAppraisal(0.75);
		System.out.println("Changing the appraisal of "
				+ stamp2.getDescription() + " from "
				+ stamp2.getAppraisedValue() + " dollars");
		stamp2.setAppraisal(72.40);

		System.out.println("\nPrinting them again...");
		System.out.println(stamp1);
		System.out.println(stamp2);

	}

}
