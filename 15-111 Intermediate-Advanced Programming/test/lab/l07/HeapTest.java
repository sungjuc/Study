package lab.l07;

import junit.framework.TestCase;

public class HeapTest extends TestCase {
	public void testInsert() {
		Heap heap = new Heap();

		heap.insert("2");
		heap.insert("3");
		heap.insert("1");

		assertEquals(" 1 3 2", heap.toString());

		heap = new Heap();
		heap.insert("9");
		assertEquals(" 9", heap.toString());
		heap.insert("8");
		assertEquals(" 8 9", heap.toString());
		heap.insert("7");
		assertEquals(" 7 9 8", heap.toString());
		heap.insert("6");
		assertEquals(" 6 7 8 9", heap.toString());
		heap.insert("5");
		assertEquals(" 5 6 8 9 7", heap.toString());
		heap.insert("4");
		assertEquals(" 4 6 5 9 7 8", heap.toString());
		heap.insert("3");
		assertEquals(" 3 6 4 9 7 8 5", heap.toString());

		System.out.println(heap.toString());
	}

	public void testRemoveMin() throws HeapException {
		Heap heap = new Heap();
		heap.insert("1");
		heap.insert("2");
		heap.insert("3");
		heap.insert("4");
		heap.insert("5");
		heap.insert("6");
		heap.insert("7");
		heap.insert("8");
		heap.insert("9");
		
		assertEquals(" 1 2 3 4 5 6 7 8 9", heap.toString());
		
		String element = (String) heap.removeMin();
		assertEquals("1", element);
		
		assertEquals(" 2 4 3 8 5 6 7 9", heap.toString());
	}

	public void testIsEmpty() throws HeapException {
		Heap heap = new Heap();
		assertTrue(heap.isEmpty());
		heap.insert("1");
		
		assertFalse(heap.isEmpty());
		heap.removeMin();

		assertTrue(heap.isEmpty());
	}
}
