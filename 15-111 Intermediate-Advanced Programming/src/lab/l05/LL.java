package lab.l05;

public class LL {

   protected LLNode head;


   /**
   *  Default constructor: creates empty list
   */
   public LL()
   {
      head = null;
   }


   /**
   *  Inserts a value at the beginning of the list.
   *  @param value to be added as the head of the list
   */
   public void addFirst(Comparable value)
   {
      head = new LLNode(value,head);
   }

  
   /**
   *  Returns a string representation of the list
   *  @return String
   */
   public String toString()
   {
     if (head == null)
       return "(empty list)" + System.getProperty("line.separator");
     String result = "";
      for (LLNode l = head; l != null; l = l.getNext())
        result += "  "+l.getValue() + System.getProperty("line.separator");

      return result;
   }


  
  //////////////////////////////////////////////////
  //
  //  Nested LLNode class
  //
  //////////////////////////////////////////////////
  
  protected class LLNode {

     //Public instance variables: no need for getters/settors
     
     /**
      *  Note <code>final</code> access modifier: cannot be changed!
      *  As a result, there is no setter for <code>value</code>.
     */
     public final Comparable value;
     
     public LLNode next;


     /**
     *  Constructor builds the LLNode with the supplied parameter;
     *  it is followed by an empty list.
     *  @param value to store in this node
     */
     public LLNode(Comparable value)
     {
        this(value, null);
     }


     /**
     *  Constructor builds the LLNode with the supplied parameters.
     *  @param value to store in this node
     *  @param next  must refer to the list that follows it
     */
     public LLNode(Comparable value, LLNode next)
     {
        this.value = value;
        this.next  = next;
     }

     
     
     //////////
     //
     //  Getters and Setters for those students who want to use them.
     //
     //////////
     
     
     /**
     *  Returns reference to the next LLNode
     *  @return next reference
     */
     public LLNode getNext()
     {
        return next;
     }


     /**
     *  Sets the next reference of this object to the paramter object
     *  @param newNode which is an object of the class LLNode
     */
     public void setNext(LLNode newNode)
     {
        next = newNode;
     }


     /**
     *  Returns reference to the value of the object.
     *  @return reference to the value
     */

     public Comparable getValue()
     {
        return value;
     }


     /**
     *  Returns string representation of the object
     *  @return String reference
     */
     public String toString()
     {
        return value.toString();
     }
  }
}
