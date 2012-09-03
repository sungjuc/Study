package lec.l05;

import junit.framework.TestCase;

public class LinkedListsTest extends TestCase {
	public void testLinkedList() {
		Node x = new Node("a", new Node("b", new Node("c", null)));
		x = x.getNext();
		x.getNext().setNext(x.getNext());

		int count = 0;
		while (x != null && count++ < 3) {
			System.out.println(x.getData());
			x = x.getNext();
		}
	}
}
