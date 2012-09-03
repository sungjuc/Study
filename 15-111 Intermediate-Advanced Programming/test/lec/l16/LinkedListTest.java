package lec.l16;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {
	LinkedList llist;

	public void testLinkedList() {
		llist = new LinkedList();
		assertNotNull(llist);
	}

	public void testAddGetFirst() {
		llist = new LinkedList();
		Object o1 = "first";
		Object o2 = "second";
		llist.addFirst(o1);
		assertEquals(o1, (Object) llist.getFirst());
		llist.addFirst(o2);
		assertEquals(o2, (Object) llist.getFirst());
	}

	public void testAddGetLast() {
		llist = new LinkedList();
		Object o1 = "first";
		Object o2 = "second";
		llist.addLast(o2);
		assertEquals(o2, (Object) llist.getLast());
		llist.addLast(o1);
		assertEquals(o1, (Object) llist.getLast());
	}

	public void testGetNth() {
		llist = new LinkedList();

		Object o1 = "first";
		Object o2 = "second";
		Object o3 = "third";
		Object o4 = "fourth";

		llist.addLast(o1);
		llist.addLast(o2);
		llist.addLast(o3);
		llist.addLast(o4);

		assertEquals(o1, (Object) llist.getNth(0));
		assertEquals(o2, (Object) llist.getNth(1));
		assertEquals(o3, (Object) llist.getNth(2));
		assertEquals(o4, (Object) llist.getNth(3));
	}

	public void testIndexOf() {
		llist = new LinkedList();

		Object o1 = "first";
		Object o2 = "second";
		Object o3 = "third";
		Object o4 = "fourth";

		llist.addLast(o1);
		llist.addLast(o2);
		llist.addLast(o3);
		llist.addLast(o4);

		assertEquals(0, llist.indexOf(o1));
		assertEquals(1, llist.indexOf(o2));
		assertEquals(2, llist.indexOf(o3));
		assertEquals(3, llist.indexOf(o4));
	}

	public void testInsertAtN() {
		llist = new LinkedList();

		Object o1 = "first";
		Object o2 = "second";
		Object o3 = "third";
		Object o4 = "fourth";
		Object o5 = "fifth";
		Object o6 = "sixth";

		llist.addLast(o1);
		llist.addLast(o2);
		llist.addLast(o3);// o1, o2, o3

		assertEquals(false, llist.insertAtN(o4, 5));
		llist.insertAtN(o4, 0); // o4, o1, o2, o3
		assertEquals(o4, llist.getFirst());
		assertEquals(o4, llist.getNth(0));
		assertEquals(o1, llist.getNth(1));
		llist.insertAtN(o5, 4); // o4, o1, o2, o3, o5
		assertEquals(o5, llist.getLast());
		assertEquals(o5, llist.getNth(4));
		assertEquals(o3, llist.getNth(3));
		llist.insertAtN(o6, 3); // o4, o1, o2, o6, o3, o5
		assertEquals(o6, llist.getNth(3));
		assertEquals(o2, llist.getNth(2));
		assertEquals(o3, llist.getNth(4));
	}

	public void testInsertBefore() {
		llist = new LinkedList();

		Object o1 = "first";
		Object o2 = "second";
		Object o3 = "third";
		Object o4 = "fourth";
		Object o5 = "fifth";

		llist.addFirst(o1);
		llist.addLast(o2);
		llist.addLast(o3);

		assertFalse(llist.insertBefore(o4, o5));
		assertTrue(llist.insertBefore(o4, o1)); // o4, o1, o2, o3
		assertEquals(o4, llist.getNth(0));
		assertEquals(o1, llist.getNth(1));
		assertEquals(o2, llist.getNth(2));
		assertTrue(llist.insertBefore(o5, o3)); // o4, o1, o2, o5, o3
		assertEquals(o2, llist.getNth(2));
		assertEquals(o5, llist.getNth(3));
		assertEquals(o3, llist.getNth(4));
	}

	public void testRemoveNth() {
		llist = new LinkedList();

		Object o1 = "first";
		Object o2 = "second";
		Object o3 = "third";
		Object o4 = "fourth";
		Object o5 = "fifth";

		llist.addFirst(o1);
		llist.addLast(o2);
		llist.addLast(o3);
		llist.addLast(o4);

		assertNull(llist.removeNth(-1));
		assertNull(llist.removeNth(4));
		assertEquals(o2, llist.removeNth(1)); // o1, o3, o4
		assertEquals(o1, llist.getNth(0));
		assertEquals(o3, llist.getNth(1));
		assertEquals(o1, llist.removeNth(0)); // o3, o4
		assertEquals(o3, llist.getNth(0));
		assertEquals(o4, llist.getNth(1));
		assertEquals(o4, llist.removeNth(1)); // o3
		assertEquals(o3, llist.getNth(0));
	}
}
