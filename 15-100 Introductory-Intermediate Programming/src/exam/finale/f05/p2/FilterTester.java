package exam.finale.f05.p2;

import exam.finale.f05.p1.Customer;

public class FilterTester

{

    public static void main(String[] args)

    { 

	  Customer cust1 = new Customer(new String("Harry Jones"),new String("Residential"), 9); 

	  Customer cust2 = new Customer(new String("Mary Smith"), new String("Business"), 5); 

	  Customer cust3 = new Customer(new String("Lynette Johnson")); 

	  Customer cust4 = new Customer(new String("Fred Beatty"), new String("Business")); 

	  Customer cust5 = new Customer(new String("Susan Zimmerman"));

	  Customer cust6 = new Customer(new String("Joseph Barnes"), new String("Residential"));

	  

	  cust1.addUsage(100);

	  cust2.addUsage(300);

	  cust3.addUsage(200);

	  cust4.addUsage(250);

	  cust5.addUsage(100);

	  cust6.addUsage(150);

	  cust1.addPhoneLine();
	  
	  cust2.addPhoneLine();


	  CustomerCollection testCollection = new CustomerCollection(); 

      	  testCollection.insertAtEnd(cust1);

         testCollection.insertAtEnd(cust2);

         testCollection.insertAtEnd(cust3);

         testCollection.insertAtEnd(cust4);

         testCollection.insertAtEnd(cust5);

         testCollection.insertAtEnd(cust6);

         System.out.println("Initial data loaded into customer collection...\n" + testCollection);

         System.out.println();

         testFilter(testCollection);

    }



    private static void testFilter(CustomerCollection testCollection)

    {

      CustomerCollection partialCollection;

      partialCollection = testCollection.filter(new String("Residential"), 225);

      System.out.println("Residential customers with less than 225 minutes used...\n" + partialCollection);

      System.out.println();

      partialCollection = testCollection.filter(new String("Residential"),175);

      System.out.println("Residential customers with less than 175 minutes used...\n" + partialCollection);

      System.out.println();

      partialCollection = testCollection.filter(new String("Residential"),125);

      System.out.println("Residential customers with less than 125 minutes used...\n" + partialCollection);

      System.out.println();

      partialCollection = testCollection.filter(new String("Business"), 500);

      System.out.println("Business customers with less than 500 minutes used...\n" + partialCollection);

      System.out.println();

      partialCollection = testCollection.filter(new String("Business"), 250);

      System.out.println("Business customers with less than 250 minutes used...\n" + partialCollection);

      System.out.println();


    }

    

  

}

