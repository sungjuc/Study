package lec.l21;

public class LLQueueTest {
	public static void main(String[] args) {
		LLQueue<String> queue = new LLQueue<String>();
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("\nReverse the queue!");
		queue = new LLQueue<String>();
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");

		queue = LLQueueUtils.reverse(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("\nReverse the queue recursively");
		queue = new LLQueue<String>();
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");

		LLQueueUtils.reverseRecursive(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	
	}
}