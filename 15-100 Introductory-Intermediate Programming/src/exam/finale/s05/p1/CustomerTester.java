package exam.finale.s05.p1;

public class CustomerTester

{

	public static void main(String[] args)

	{

		Customer cust1 = new Customer(new String("Harry Jones"), new String(
				"Residential"));

		Customer cust2 = new Customer(new String("Mary Smith"), new String(
				"Business"));

		Customer cust3 = new Customer(new String("Lynette Johnson"), 0.40);

		Customer cust4 = new Customer(new String("Fred Beatty"), 1.00);

		Customer cust5 = new Customer(new String("Susan Zimmerman"));

		System.out.println();

		System.out.println("Our initial customers: ");

		System.out.println(cust1.getName()

		+ "- TYPE: " + cust1.getTypeOfService()

		+ ", RATE: $" + cust1.getRate()

		+ ", HOURS: " + cust1.getHours()

		+ ", TOTAL: $" + cust1.getTotalCost());

		System.out.println(cust2.getName()

		+ "- TYPE: " + cust2.getTypeOfService()

		+ ", RATE: $" + cust2.getRate()

		+ ", HOURS: " + cust2.getHours()

		+ ", TOTAL: $" + cust2.getTotalCost());

		System.out.println(cust3.getName()

		+ "- TYPE: " + cust3.getTypeOfService()

		+ ", RATE: $" + cust3.getRate()

		+ ", HOURS: " + cust3.getHours()

		+ ", TOTAL: $" + cust3.getTotalCost());

		System.out.println(cust4.getName()

		+ "- TYPE: " + cust4.getTypeOfService()

		+ ", RATE: $" + cust4.getRate()

		+ ", HOURS: " + cust4.getHours()

		+ ", TOTAL: $" + cust4.getTotalCost());

		System.out.println(cust5.getName()

		+ "- TYPE: " + cust5.getTypeOfService()

		+ ", RATE: $" + cust5.getRate()

		+ ", HOURS: " + cust5.getHours()

		+ ", TOTAL: $" + cust5.getTotalCost());

		System.out.println();

		System.out.println("-----");

		System.out.println();

		// Successful execution up to this point will receive 4 points.

		// If these 4 points are earned, an additional 4 points will be

		// earned if the remaining code executes correctly.

		cust1.addUsage(1);

		cust2.addUsage(2);

		cust3.addUsage(5);

		cust4.addUsage(4);

		cust5.addUsage(5);

		System.out.println("Our customers after some usage: ");

		System.out.println(cust1);

		System.out.println(cust2);

		System.out.println(cust3);

		System.out.println(cust4);

		System.out.println(cust5);

		System.out.println();

		System.out.println("Our customers after some more usage: ");

		cust1.addUsage(4);

		cust2.addUsage(20);

		cust3.addUsage(40);

		cust4.addUsage(16);

		cust5.addUsage(12);

		System.out.println(cust1);

		System.out.println(cust2);

		System.out.println(cust3);

		System.out.println(cust4);

		System.out.println(cust5);

		System.out.println();

		cust1.addUsage(10);

		cust2.addUsage(8);

		cust3.addUsage(6);

		cust4.addUsage(4);

		cust5.addUsage(5);

		System.out.println("Our Customers after even more usage: ");

		System.out.println(cust1);

		System.out.println(cust2);

		System.out.println(cust3);

		System.out.println(cust4);

		System.out.println(cust5);

		System.out.println();

		System.out.println("Testing equality of customers: ");

		System.out.println(cust1.getName() + " and " + cust2.getName() + " : "
				+ cust1.equals(cust2));

		System.out.println(cust1.getName() + " and " + cust3.getName() + " : "
				+ cust1.equals(cust3));

		System.out.println(cust1.getName() + " and " + cust4.getName() + " : "
				+ cust1.equals(cust4));

		System.out.println(cust1.getName() + " and " + cust5.getName() + " : "
				+ cust1.equals(cust5));

		System.out.println(cust2.getName() + " and " + cust3.getName() + " : "
				+ cust2.equals(cust3));

		System.out.println(cust2.getName() + " and " + cust4.getName() + " : "
				+ cust2.equals(cust4));

		System.out.println(cust2.getName() + " and " + cust5.getName() + " : "
				+ cust2.equals(cust5));

		System.out.println(cust3.getName() + " and " + cust4.getName() + " : "
				+ cust3.equals(cust4));

		System.out.println(cust3.getName() + " and " + cust5.getName() + " : "
				+ cust3.equals(cust5));

		System.out.println(cust4.getName() + " and " + cust5.getName() + " : "
				+ cust4.equals(cust5));

		System.out.println();

	}

}
