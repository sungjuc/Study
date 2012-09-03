package exam.finale.exam4c.p2;

import exam.finale.exam4c.p1.Stamp;

public class RemoveTester
{
    public static void main(String[] args)
    {
      StampList test = new StampList();  // all data is guaranteed to fit

      load(test);  // this method is provided for you to load the StampList
      System.out.println("Initial data loaded into StampList...\n" + test);
      System.out.println();
      
      testRemove(test);
    }

    private static void testRemove(StampList test)
    {
      System.out.println("\nREMOVAL TESTS...\n");
      System.out.println("Removing element");
      test.remove();
      System.out.println(test);
      System.out.println();

      System.out.println("Removing element");
      test.remove();
      System.out.println(test);
      System.out.println();

      System.out.println("Removing element");
      test.remove();
      System.out.println(test);
      System.out.println();
      
      System.out.println("Removing element");
      test.remove();
      System.out.println(test);
      System.out.println();
            
      System.out.println("Attempting removing");
      test.remove();;
      System.out.println(test);
      System.out.println(); 
          

   }
   
    public static void load(StampList a)
    {
		a.insertAtEnd(new Stamp("Lincoln (US 1940)", 3, 15.05));
		a.insertAtEnd(new Stamp("Young Elvis (US 1995)", 33, 1.35));
		a.insertAtEnd(new Stamp("Liberty (US 1955)", 5, 20.0));
		a.insertAtEnd(new Stamp("Blue Loon (Can 1970)", 25, 10.5));	

    }
}
