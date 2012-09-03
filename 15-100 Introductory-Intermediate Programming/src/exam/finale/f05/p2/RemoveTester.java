package exam.finale.f05.p2;

import exam.finale.f05.p1.Customer;

public class RemoveTester
{
    public static void main(String[] args)
    {
	  Customer cust1 = new Customer(new String("Harry Jones"),new String("Residential")); 
	  Customer cust2 = new Customer(new String("Mary Smith"), new String("Business")); 
	  Customer cust3 = new Customer(new String("Lynette Johnson"), new String("Business"), 5); 
	  Customer cust4 = new Customer(new String("Fred Beatty"), new String("Residential"), 9); 
	  Customer cust5 = new Customer(new String("Susan Zimmerman"));
	  Customer cust6 = new Customer(new String("Joseph Barnes"));
  
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
      System.out.println("Initial data loaded into CustomerCollection...\n" + testCollection);
      System.out.println();
      
      testRemove(testCollection);
    }

    private static void testRemove(CustomerCollection testCollection)
    {
      System.out.println("\nREMOVAL TESTS...\n");
      String r1 = new String("Daffy Duck");
      System.out.println("Removing " + r1);
      testCollection.remove(r1);
      System.out.println(testCollection);
      System.out.println();

      String r2 = new String("Joseph Barnes");
      System.out.println("Removing " + r2);
      testCollection.remove(r2);
      System.out.println(testCollection);
      System.out.println();

      String r3 = new String("Lynette Johnson");
      System.out.println("Removing " + r3);
      testCollection.remove(r3);
      System.out.println(testCollection);
      System.out.println();
      
      String r4 = new String("Harry Jones");
      System.out.println("Removing " + r4);
      testCollection.remove(r4);
      System.out.println(testCollection);
      System.out.println();

      String r5 = new String("Susan Zimmerman");
      System.out.println("Removing " + r5);
      testCollection.remove(r5);
      System.out.println(testCollection);
      System.out.println();
      
      String r6 = new String("Mary Smith");
      System.out.println("Removing " + r6);
      testCollection.remove(r6);
      System.out.println(testCollection);
      System.out.println();
      
      String r7 = new String("Fred Beatty");
      System.out.println("Removing " + r7);
      testCollection.remove(r7);
      System.out.println(testCollection);
      System.out.println();

      System.out.println("Removing " + r5);
      testCollection.remove(r5);
      System.out.println(testCollection);
      System.out.println();

    }
}
