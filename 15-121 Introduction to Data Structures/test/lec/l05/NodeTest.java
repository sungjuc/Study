package lec.l05;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
	public void testNode() {
		Node n;
		Node anotherNode = new Node("anotherNode", null);
		n = new Node("Hello", anotherNode);

		assertEquals("Hello", n.getData());
		assertSame(anotherNode, n.getNext());
	}
}
