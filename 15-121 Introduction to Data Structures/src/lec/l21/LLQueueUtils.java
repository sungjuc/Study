package lec.l21;

import lec.l20.LLStack;

public class LLQueueUtils{
	public static LLQueue<String> reverse(LLQueue<String> queue) {
		LLStack<String> stack = new LLStack<String>();
		
		while(!queue.isEmpty()) {
			stack.push(queue.dequeue());
		}
		
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
	
		return queue;
	}

	public static void reverseRecursive(LLQueue<String> queue) {
		if (!queue.isEmpty()) {
			String data = queue.dequeue();
			reverseRecursive(queue);
			queue.enqueue(data);
		}
	}
}