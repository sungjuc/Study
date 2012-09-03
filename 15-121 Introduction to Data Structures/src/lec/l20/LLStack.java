package lec.l20;

public class LLStack<E> implements Stack<E> {
	private Node<E> top;
	
	public void push(E data) {
		top = new Node<E>(data, top);
	}

	public boolean isEmpty() {
		return top == null;
	}

	public E pop() {
		Node<E> temp = top;
		top = top.getNext();
		return temp.getData();
	}

	public E peek() {
		return top.getData();
	}

}