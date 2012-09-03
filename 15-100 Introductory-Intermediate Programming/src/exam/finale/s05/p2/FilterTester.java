package exam.finale.s05.p2;

import exam.finale.s05.p1.Customer;

public class FilterTester

{

	public static void main(String[] args)

	{

		Customer cust1 = new Customer(new String("Harry Jones"), new String(
				"Residential"));

		Customer cust2 = new Customer(new String("Mary Smith"), new String(
				"Business"));

		Customer cust3 = new Customer(new String("Lynette Johnson"), 0.50);

		Customer cust4 = new Customer(new String("Fred Beatty"), 0.75);

		Customer cust5 = new Customer(new String("Susan Zimmerman"));

		Customer cust6 = new Customer(new String("Joseph Barnes"), 0.40);

		cust1.addUsage(10);

		cust2.addUsage(30);

		cust3.addUsage(20);

		cust4.addUsage(25);

		cust5.addUsage(10);

		cust6.addUsage(15);

		CustomerCollection testCollection = new CustomerCollection();

		testCollection.insertAtEnd(cust1);

		testCollection.insertAtEnd(cust2);

		testCollection.insertAtEnd(cust3);

		testCollection.insertAtEnd(cust4);

		testCollection.insertAtEnd(cust5);

		testCollection.insertAtEnd(cust6);

		System.out.println("Initial data loaded into customer collection...\n"
				+ testCollection);

		System.out.println();

		testFilter(testCollection);

	}

	private static void testFilter(CustomerCollection testCollection)

	{

		CustomerCollection partialCollection;

		partialCollection = testCollection.filter(new String("Residential"),
				50.00);

		System.out.println("Residential customers with cost under $50.00...\n"
				+ partialCollection);

		System.out.println();

		partialCollection = testCollection.filter(new String("Residential"),
				12.00);

		System.out.println("Residential customers with cost under $12.00...\n"
				+ partialCollection);

		System.out.println();

		partialCollection = testCollection.filter(new String("Residential"),
				6.00);

		System.out.println("Residential customers with cost under $6.00...\n"
				+ partialCollection);

		System.out.println();

		partialCollection = testCollection
				.filter(new String("Business"), 50.00);

		System.out.println("Business customers with cost under $50.00...\n"
				+ partialCollection);

		System.out.println();

		partialCollection = testCollection
				.filter(new String("Business"), 12.00);

		System.out.println("Business customers with cost under $12.00...\n"
				+ partialCollection);

		System.out.println();

		partialCollection = testCollection.filter(new String("Business"), 6.00);

		System.out.println("Business customers with cost under $6.00...\n"
				+ partialCollection);

	}

}
