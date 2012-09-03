package lab.l05;

/**
 * Test driver for the LinkedList class.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 5
 */
public class LinkedListTest {
	public static void main(String[] args) {
		/**
		 * Tests for the removeAllMatchingItmes
		 */
		// Against empty list
		LinkedList linkedList = new LinkedList();
		System.out.println("New empty linked list is created.");
		linkedList.removeAllMatchingItmes("abc");

		// The case list contains the item to be deleted.
		linkedList.addFirst("abc");
		System.out.println("abc is added");
		linkedList.addFirst("aaa");
		System.out.println("aaa is added");
		linkedList.addFirst("bbb");
		System.out.println("bbb is added");
		linkedList.addFirst("abc");
		System.out.println("abc is added");
		System.out.println(linkedList);

		linkedList.removeAllMatchingItmes("abc");
		System.out.println("abc is removed");
		System.out.println(linkedList);

		// The case list doesn't contain the item to be deleted.
		linkedList.removeAllMatchingItmes("ddd");
		System.out.println("ddd is removed");
		System.out.println(linkedList);

		// The case remove all elements from list.
		linkedList.removeAllMatchingItmes("aaa");
		System.out.println("aaa is removed");
		System.out.println(linkedList);
		linkedList.removeAllMatchingItmes("bbb");
		System.out.println("bbb is removed");
		System.out.println(linkedList);

		// Test case remove elements which is the only elements in the list.
		linkedList.addFirst(1);
		System.out.println("1 is added");
		linkedList.addFirst(1);
		System.out.println("1 is added");
		linkedList.addFirst(1);
		System.out.println("1 is added");
		linkedList.addFirst(1);
		System.out.println("1 is added");
		linkedList.addFirst(1);
		System.out.println("1 is added");
		System.out.println(linkedList);

		linkedList.removeAllMatchingItmes(1);
		System.out.println("1 is removed");
		System.out.println(linkedList);

		// Add same element in the list.
		linkedList.addFirst(1);
		System.out.println("1 is added");
		System.out.println(linkedList);

		/**
		 * Tests for the removeOddItmes
		 */
		linkedList = new LinkedList();
		System.out.println("New empty linked list is created.");

		linkedList.removeOddItems();
		linkedList.addFirst("5");
		System.out.println("5 is added");
		linkedList.addFirst("4");
		System.out.println("4 is added");
		linkedList.addFirst("3");
		System.out.println("3 is added");
		linkedList.addFirst("2");
		System.out.println("2 is added");
		linkedList.addFirst("1");
		System.out.println("1 is added");
		linkedList.addFirst("0");
		System.out.println("0 is added");

		System.out.println(linkedList);

		// Remove odd items.
		linkedList.removeOddItems();
		System.out.println(linkedList);

		linkedList.removeOddItems();
		System.out.println(linkedList);

		linkedList.removeOddItems();
		System.out.println(linkedList);

		// Remove from only one item.
		linkedList.removeOddItems();
		System.out.println(linkedList);

	}
}
