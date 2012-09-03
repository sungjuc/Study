package lec.l21;

import lec.l20.Node;
import lec.l20.Queue;

public class LLQueue<E> implements Queue<E>{
	Node<E> front;
	Node<E> end;
	int count = 0;

	public void enqueue(E data) {
		Node<E> node = new Node<E>(data, null);
		
		if (end != null)
			end.setNext(node);

		end = node;
		if (front == null)
			front = end;
		count++;
	}

	public E dequeue() {
		Node<E> temp = front;
		if(front.getNext() != null)
			front = front.getNext();
		else
			front = null;

		count--;
		return temp.getData();
	}

	public E peek() {
		return front.getData();
	}

	public boolean isEmpty() {
		return count == 0;
	}
}