package lec.l05;

import junit.framework.TestCase;

public class LinkedListsUtilTests extends TestCase {
	public void testGetThird() {
		Node list = new Node("a", new Node("b", new Node("c", new Node("d",
				null))));
		assertEquals("c", LinkedListsUtils.getThird(list));
	}

	public void testSetSecond() {
		Node list = new Node("a", new Node("b", null));
		LinkedListsUtils.insertSecond(list, "my");
		assertEquals("my", list.getNext().getData());
	}

	public void testSize() {
		Node list = new Node("a", new Node("b", new Node("c", new Node("d",
				null))));
		assertEquals(4, LinkedListsUtils.size(list));
	}
}
