package lab.l09;

import junit.framework.TestCase;

public class UnionFindTests extends TestCase {

	public void testSimple() {
		// Initialize the test elements
		int size = 8;
		UnionFind uf = new UnionFind(size);

		// For the first time, there is no element in same set.
		checkAllNotInSameSet(size, uf);
		
		// Do the union and check whether elements union properly.
		uf.union(1, 7);
		assertTrue(uf.find(1, 7));

		assertFalse(uf.find(1, 2));
		uf.union(1, 2);
		assertTrue(uf.find(1, 2));
		assertTrue(uf.find(2, 7));

		assertFalse(uf.find(7, 0));
		uf.union(7, 0);
		assertTrue(uf.find(7, 0));
		assertTrue(uf.find(2, 0));
		assertTrue(uf.find(1, 0));

		assertFalse(uf.find(6, 4));
		assertFalse(uf.find(4, 6));
		uf.union(6, 4);
		assertTrue(uf.find(6, 4));
		assertTrue(uf.find(4, 6));

		assertFalse(uf.find(4, 7));

		assertFalse(uf.find(6, 5));
		assertFalse(uf.find(5, 6));
		uf.union(6, 5);
		assertTrue(uf.find(6, 5));
		assertTrue(uf.find(5, 6));
		assertTrue(uf.find(4, 5));
		assertTrue(uf.find(5, 4));

		assertFalse(uf.find(4, 1));
		assertFalse(uf.find(1, 4));
		uf.union(4, 1);
		assertTrue(uf.find(4, 1));
		assertTrue(uf.find(1, 4));
		assertTrue(uf.find(1, 5));
		assertTrue(uf.find(5, 1));

		assertFalse(uf.find(2, 3));
		assertFalse(uf.find(3, 2));
		uf.union(2, 3);

		// Finally, all elements are in same set
		checkAllInSameSet(size, uf);
	}

	public void testSample() {
		// Initialize the test environments
		int size = 5;
		UnionFind uf = new UnionFind(size);

		// For the first time, all elements is not in same set.
		checkAllNotInSameSet(size, uf);

		// Check the union is done in properly.
		uf.union(1, 4);
		assertTrue(uf.find(1, 4));

		uf.union(2, 4);
		assertTrue(uf.find(2, 4));
		assertTrue(uf.find(1, 2));

		uf.union(0, 3);
		assertTrue(uf.find(0, 3));

		uf.union(3, 4);

		// Finally, all elements are in same set.
		checkAllInSameSet(size, uf);
	}

	private void checkAllNotInSameSet(int size, UnionFind uf) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j)
					assertFalse(uf.find(i, j));
			}
		}
	}

	private void checkAllInSameSet(int size, UnionFind uf) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j)
					assertTrue(uf.find(i, j));
			}
		}
	}
}
