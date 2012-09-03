package lec.l19;

public class ArrayListQueue {
	private Object[] queue;
	private int headIndex;
	private int tailIndex;
	private int count;

	public ArrayListQueue(int size) {
		queue = new Object[size];

		headIndex = 0;
		tailIndex = 0;
		count = 0;
	}

	public boolean enqueue(Object addObj) {
		if (count == queue.length)
			return false;

		queue[tailIndex] = addObj;
		tailIndex = (tailIndex + 1) % queue.length;

		count++;

		return true;
	}

	public Object dequeue() {
		if (count <= 0)
			return null;

		Object dequeueObj = queue[headIndex];
		queue[headIndex] = null;
		headIndex = (headIndex + 1) % queue.length;

		count--;

		return dequeueObj;
	}

	public Object peek() {
		if (count <= 0)
			return null;

		return queue[headIndex];
	}

	public boolean isEmpty() {
		return (count <= 0);
	}
}
