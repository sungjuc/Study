package exam.finale.f05.p1;
import java.text.NumberFormat;

public class CustomerTester {
	public static void main(String[] args) {

		Customer cust1 = new Customer(new String("Harry Jones"), new String(
				"Residential"), 6);
		Customer cust2 = new Customer(new String("Mary Smith"), new String(
				"Business"), 3);
		Customer cust3 = new Customer(new String("Lynette Johnson"),
				new String("Residential"));
		Customer cust4 = new Customer(new String("Fred Beatty"), new String(
				"Business"));
		Customer cust5 = new Customer(new String("Susan Zimmerman"));

		System.out.println();
		System.out.println("Our initial customers: ");
		System.out.println(cust1.getName() + "- TYPE: "
				+ cust1.getTypeOfService() + ", RATE: " + cust1.getRate()
				+ "c/min, MINUTES: " + cust1.getMinutes() + ", PHONE LINES:"
				+ cust1.getNumPhoneLines());
		System.out.println(cust2.getName() + "- TYPE: "
				+ cust2.getTypeOfService() + ", RATE: " + cust2.getRate()
				+ "c/min, MINUTES: " + cust2.getMinutes() + ", PHONE LINES:"
				+ cust2.getNumPhoneLines());
		System.out.println(cust3.getName() + "- TYPE: "
				+ cust3.getTypeOfService() + ", RATE: " + cust3.getRate()
				+ "c/min, MINUTES: " + cust3.getMinutes() + ", PHONE LINES:"
				+ cust3.getNumPhoneLines());
		System.out.println(cust4.getName() + "- TYPE: "
				+ cust4.getTypeOfService() + ", RATE: " + cust4.getRate()
				+ "c/min, MINUTES: " + cust4.getMinutes() + ", PHONE LINES:"
				+ cust4.getNumPhoneLines());
		System.out.println(cust5.getName() + "- TYPE: "
				+ cust5.getTypeOfService() + ", RATE: " + cust5.getRate()
				+ "c/min, MINUTES: " + cust5.getMinutes() + ", PHONE LINES:"
				+ cust5.getNumPhoneLines());
		System.out.println();

		cust1.addUsage(100); // customer 1 uses phone for 100 minutes
		cust2.addUsage(200); // customer 2 uses phone for 200 minutes
		cust3.addUsage(300); // etc.
		cust4.addUsage(400);
		cust5.addUsage(500);

		cust1.addPhoneLine(); // customer 1 adds one phone line
		cust2.addPhoneLine(); // customer 2 adds one phone line
		cust3.addPhoneLine(); // customer 3 adds one phone line

		System.out.println("Our customers after some time: ");

		System.out.println(cust1); // prints the returned string from the
		// toString method from customer 1
		System.out.println(cust2); // etc.
		System.out.println(cust3);
		System.out.println(cust4);
		System.out.println(cust5);
		System.out.println();

		cust1.addUsage(150); // customer 1 uses phone for another 150 minutes
		cust2.addUsage(300); // customer 2 uses phone for another 300 minutes
		cust3.addUsage(600); // etc.
		cust4.addUsage(300);
		cust5.addUsage(150);

		cust1.addPhoneLine(); // customer 1 adds one phone line
		cust2.removePhoneLine(); // customer 2 removes one phone line
		cust5.addPhoneLine(); // customer 4 adds one phone line

		System.out.println("Our customers after some more time: ");

		System.out.println(cust1);
		System.out.println(cust2);
		System.out.println(cust3);
		System.out.println(cust4);
		System.out.println(cust5);
		System.out.println();

		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		System.out.println("Print out bills for our customers: ");
		System.out.println(cust1.getName() + ": "
				+ formatter.format(cust1.getTotalCharge()));
		System.out.println(cust2.getName() + ": "
				+ formatter.format(cust2.getTotalCharge()));
		System.out.println(cust3.getName() + ": "
				+ formatter.format(cust3.getTotalCharge()));
		System.out.println(cust4.getName() + ": "
				+ formatter.format(cust4.getTotalCharge()));
		System.out.println(cust5.getName() + ": "
				+ formatter.format(cust5.getTotalCharge()));
		System.out.println();

		System.out.println("Customers that are \"equal\":");

		boolean anyEqual = false;
		if (cust1.equals(cust2)) {
			System.out.println(cust1.getName() + " and " + cust2.getName());
			anyEqual = true;
		}
		if (cust1.equals(cust3)) {
			System.out.println(cust1.getName() + " and " + cust3.getName());
			anyEqual = true;
		}
		if (cust1.equals(cust4)) {
			System.out.println(cust1.getName() + " and " + cust4.getName());
			anyEqual = true;
		}
		if (cust1.equals(cust5)) {
			System.out.println(cust1.getName() + " and " + cust5.getName());
			anyEqual = true;
		}
		if (cust2.equals(cust3)) {
			System.out.println(cust2.getName() + " and " + cust3.getName());
			anyEqual = true;
		}
		if (cust2.equals(cust4)) {
			System.out.println(cust2.getName() + " and " + cust4.getName());
			anyEqual = true;
		}
		if (cust2.equals(cust5)) {
			System.out.println(cust2.getName() + " and " + cust5.getName());
			anyEqual = true;
		}
		if (cust3.equals(cust4)) {
			System.out.println(cust3.getName() + " and " + cust4.getName());
			anyEqual = true;
		}
		if (cust3.equals(cust5)) {
			System.out.println(cust3.getName() + " and " + cust5.getName());
			anyEqual = true;
		}
		if (cust4.equals(cust5)) {
			System.out.println(cust4.getName() + " and " + cust5.getName());
			anyEqual = true;
		}
		if (!anyEqual)
			System.out.println("NO CUSTOMERS ARE EQUAL.");

	}

}