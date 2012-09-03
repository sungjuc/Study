package exam.e03.a;

class ContainerTester {
  public static void main (String[] args) {

   // Create containers
   Container boys = new Container(20);
   Container girls = new Container(20);
   Container merged = null;

   // Fill boys
   boys.insertAtEnd ("Greg");
   boys.insertAtEnd ("Mark");
   boys.insertAtEnd ("Jim");
   boys.insertAtEnd ("Rich");
   boys.insertAtEnd ("Ananda");
   boys.insertAtEnd ("Tim");
   boys.insertAtEnd ("Klaus");
   System.out.println ("Boys..."); 
   System.out.println (boys);
   System.out.println ("");

   // Fill girls
   girls.insertAtEnd ("Heather");
   girls.insertAtEnd ("Angie");
   girls.insertAtEnd ("Mary");
   girls.insertAtEnd ("Jeannette");
   girls.insertAtEnd ("Mor");
   girls.insertAtEnd ("Manuela");
   girls.insertAtEnd ("Lori");
   System.out.println ("Girls..."); 
   System.out.println (girls);
   System.out.println ("");

  
   // Merge same sized lists
   merged = boys.mergeAlternate(girls);   
   System.out.println ("Merge same sized lists...");
   System.out.println (merged);
   System.out.println ("");

   // Add more boys
   boys.insertAtEnd ("Jacobo");
   boys.insertAtEnd ("David");

   // Merge smaller list into bigger one
   merged = boys.mergeAlternate(girls);   
   System.out.println ("Merged smaller list into bigger one...");
   System.out.println (merged);
   System.out.println ("");

   // Merge bigger list into smaller one
   merged = girls.mergeAlternate(boys);   
   System.out.println ("Merged bigger list into smaller one...");
   System.out.println (merged);
   System.out.println ("");
  
  }
}
