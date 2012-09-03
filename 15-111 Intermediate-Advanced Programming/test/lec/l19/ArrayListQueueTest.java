package lec.l19;

import junit.framework.TestCase;

public class ArrayListQueueTest extends TestCase {
	ArrayListQueue queue;

	protected void setUp() {
		queue = new ArrayListQueue(10);
	}

	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	public void testEnqueue() {
		assertTrue(queue.enqueue("1"));
		assertEquals("1", queue.peek());
		assertTrue(queue.enqueue("2"));
		assertTrue(queue.enqueue("3"));
		assertTrue(queue.enqueue("4"));
		assertTrue(queue.enqueue("5"));
		assertTrue(queue.enqueue("6"));
		assertTrue(queue.enqueue("7"));
		assertTrue(queue.enqueue("8"));
		assertTrue(queue.enqueue("9"));
		assertTrue(queue.enqueue("10"));
		assertFalse(queue.enqueue("11"));
		assertFalse(queue.isEmpty());
	}

	public void testPeek() {
		assertTrue(queue.enqueue("1"));
		assertEquals("1", queue.peek());
	}

	public void testDequeue() {
		assertTrue(queue.enqueue("1"));
		assertTrue(queue.enqueue("2"));
		assertTrue(queue.enqueue("3"));
		assertTrue(queue.enqueue("4"));
		assertTrue(queue.enqueue("5"));
		assertTrue(queue.enqueue("6"));
		assertTrue(queue.enqueue("7"));
		assertTrue(queue.enqueue("8"));
		assertTrue(queue.enqueue("9"));
		assertTrue(queue.enqueue("10"));
		assertEquals("1", queue.dequeue());
		assertEquals("2", queue.dequeue());
		assertEquals("3", queue.dequeue());
		assertEquals("4", queue.dequeue());
		assertEquals("5", queue.dequeue());
		assertEquals("6", queue.dequeue());
		assertEquals("7", queue.dequeue());
		assertEquals("8", queue.dequeue());
		assertEquals("9", queue.dequeue());
		assertEquals("10", queue.dequeue());
		assertNull(queue.dequeue());
	}
}
