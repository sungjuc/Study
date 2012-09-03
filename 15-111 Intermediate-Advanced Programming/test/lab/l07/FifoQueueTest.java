package lab.l07;

import junit.framework.TestCase;

public class FifoQueueTest extends TestCase {
	public void testInsert(){
		FifoQueue queue = new FifoQueue();
		queue.insert("1");
		queue.insert("2");
		queue.insert("3");
		assertEquals("[1, 2, 3]", queue.toString());
	}
	
	public void testRemoveMin(){
		FifoQueue queue = new FifoQueue();
		queue.insert("1");
		queue.insert("2");
		queue.insert("3");
		Comparable element = queue.removeMin();
		assertEquals("1", element);
		assertEquals("[2, 3]", queue.toString());
	}
}
