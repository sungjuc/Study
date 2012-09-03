package lab.l06;

import junit.framework.TestCase;

public class BinaryTreeTest extends TestCase {
	BinaryTree nullTree;
	BinaryTree bTree;
	BinaryTree oneItemTree;

	public void setUp() {
		nullTree = new BinaryTree();
		bTree = new BinaryTree();
		bTree.insert("3");
		bTree.insert("2");
		bTree.insert("1");
		bTree.insert("5");
		bTree.insert("4");
		bTree.insert("6");
		oneItemTree = new BinaryTree();
		oneItemTree.insert("1");
	}

	public void testCloneTree() {
		assertEquals(nullTree.toString(), nullTree.cloneTree().toString());
		assertEquals(bTree.toString(), bTree.cloneTree().toString());
	}

	public void testPrintPath() {
		// Path to null tree
		nullTree.printPath("3");

		// Path to the root elements.
		bTree.printPath("3");

		// Path to the internal nodes.
		bTree.printPath("2");

		// Path to the internal nodes.
		bTree.printPath("1");

		// Path to the internal nodes.
		bTree.printPath("4");

		// Path to the internal nodes.
		bTree.printPath("5");

		// Path to the internal nodes.
		bTree.printPath("6");

		// No item in the tree
		bTree.printPath("9");
	}

	public void testMaxLeafLevel() {
		assertEquals(-1, nullTree.maxLeafLevel());
		assertEquals(2, bTree.maxLeafLevel());
		assertEquals(0, oneItemTree.maxLeafLevel());
		oneItemTree.insert("10");
		assertEquals(1, oneItemTree.maxLeafLevel());
	}

	public void testPrintLeavesAtLevel() {
		System.out.println(bTree.toString());
		System.out.println("Level 0: 3");
		bTree.printLeavesAtLevel(0);
		System.out.println("Level 1: 2, 5");
		bTree.printLeavesAtLevel(1);
		System.out.println("Level 2: 1, 4, 6");
		bTree.printLeavesAtLevel(2);
		System.out.println("Level 3: nothing");
		bTree.printLeavesAtLevel(3);
		System.out.println("Level -1: nothing");
		bTree.printLeavesAtLevel(-1);
	}
}