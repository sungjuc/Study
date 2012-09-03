package lec.l16;

import junit.framework.TestCase;

public class SinglyLinkedListTest extends TestCase {
	public void testAddLastIterative() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLastIterative("first");
		assertEquals(1, list.size());
		list.addLastIterative("second");
		assertEquals(2, list.size());
	}

	public void testAddLastRecursive(){
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addLastRecursive("first");
		assertEquals(1, list.size());
		list.addLastRecursive("second");
		assertEquals(2, list.size());	
	}
}
