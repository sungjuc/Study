package exam.finale.f05.p2;

import exam.finale.f05.p1.Customer;

public class InsertTester
{
    public static void main(String[] args)
    {

	  CustomerCollection testCollection = new CustomerCollection(); 

      System.out.println("Initial customer collection is empty...\n" + testCollection);
      System.out.println();
      
      testInsert(testCollection);
    }

    private static void testInsert(CustomerCollection testCollection)
    {
      System.out.println("\nINSERTION TESTS...\n");
      
      Customer test1 = new Customer(new String("Harry Jones"),new String("Residential")); 
	  test1.addUsage(100);
	  System.out.println("Inserting " + test1);
      testCollection.insert(test1);
      System.out.println(testCollection);
      System.out.println();

	  Customer test2 = new Customer(new String("Mary Smith"), new String("Business")); 
	  test2.addUsage(300);
	  System.out.println("Inserting " + test2);
      testCollection.insert(test2);
      System.out.println(testCollection);
      System.out.println();

	  Customer test3 = new Customer(new String("Lynette Johnson"), new String("Residential"), 5); 
	  test3.addUsage(200);
	  System.out.println("Inserting " + test3);
      testCollection.insert(test3);
      System.out.println(testCollection);
      System.out.println();

	  Customer test4 = new Customer(new String("Fred Beatty"), new String("Business"), 3); 
	  test4.addUsage(250);
	  System.out.println("Inserting " + test4);
      testCollection.insert(test4);
      System.out.println(testCollection);
      System.out.println();

      Customer test5 = new Customer(new String("Susan Zimmerman"));
        test5.addUsage(100);
        test5.addPhoneLine();
      System.out.println("Inserting " + test5);
      testCollection.insert(test5);
      System.out.println(testCollection);
      System.out.println();

      Customer test6 = new Customer(new String("Joseph Barnes"), new String("Residential"), 7);
        test6.addUsage(150);
        test6.addPhoneLine();
      System.out.println("Inserting " + test6);
      testCollection.insert(test6);
      System.out.println(testCollection);
      System.out.println();

      System.out.println("Inserting " + test1);
      testCollection.insert(test1);
      System.out.println(testCollection);
      System.out.println();

      System.out.println("Inserting " + test4);
      testCollection.insert(test4);
      System.out.println(testCollection);
      System.out.println();

      Customer test7 = new Customer(new String("Bugs Bunny"),new String("Business"));
        test7.addUsage(25);
      System.out.println("Inserting " + test7);
      testCollection.insert(test7);
      System.out.println(testCollection);
      System.out.println();
    }
}
