package lec.l06;

import junit.framework.TestCase;
import lec.l05.LinkedListsUtils;
import lec.l05.Node;

public class LinkedListUtils2Test extends TestCase {
	public void testaddLast() {
		Node list = new Node("a", new Node("b", null));
		LinkedListsUtils2.addLast(list, "c");

		assertEquals(3, LinkedListsUtils.size(list));
	}

	public void testRemoveLast() {
		Node list = new Node("a", new Node("b", null));
		LinkedListsUtils2.removeLast(list);

		assertEquals(1, LinkedListsUtils.size(list));
	}
}
