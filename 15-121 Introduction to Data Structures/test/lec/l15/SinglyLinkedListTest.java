package lec.l15;

import junit.framework.TestCase;

public class SinglyLinkedListTest extends TestCase {
	public void testSinglyLinkedList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertNotNull(list);
	}

	public void testGetFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("first");
		assertEquals("first", list.getFirst());
	}

	public void testSize() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("first");
		list.addFirst("second");
		list.addFirst("third");
		list.addFirst("fourth");
		assertEquals(4, list.size());
	}
}
