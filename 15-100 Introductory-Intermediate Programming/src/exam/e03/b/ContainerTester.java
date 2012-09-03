package exam.e03.b;

class ContainerTester {
  public static void main (String[] args) {

   // Create containers
   Container set1 = new Container(20);
   Container set2 = new Container(20);
   Container result = null;

   // Fill set1
   set1.insertAtEnd ("Greg");
   set1.insertAtEnd ("Mark");
   set1.insertAtEnd ("Jim");
   set1.insertAtEnd ("Rich");
   set1.insertAtEnd ("Ananda");
   set1.insertAtEnd ("Tim");
   set1.insertAtEnd ("Klaus");
   set1.insertAtEnd ("Jacobo");
   set1.insertAtEnd ("David");
   System.out.println ("Set1..."); 
   System.out.println (set1);
   System.out.println ("");

   // Fill set2
   set2.insertAtEnd ("Jim");
   set2.insertAtEnd ("Heather");
   set2.insertAtEnd ("Rich");
   set2.insertAtEnd ("Mary");
   set2.insertAtEnd ("Tim");
   set2.insertAtEnd ("Klaus");
   set2.insertAtEnd ("David");
   set2.insertAtEnd ("Manuela");
   System.out.println ("Set2..."); 
   System.out.println (set2);
   System.out.println ("");

  
   // Let it rip...
   result = set1.sortedHalfXor(set2);
   System.out.println ("set1.sortedHalfXor(set2)...");
   System.out.println (result);
   System.out.println ("");

  
   // Let it rip...
   result = set2.sortedHalfXor(set1);
   System.out.println ("set2.sortedHalfXor(set1)...");
   System.out.println (result);
   System.out.println ("");

  }
}
