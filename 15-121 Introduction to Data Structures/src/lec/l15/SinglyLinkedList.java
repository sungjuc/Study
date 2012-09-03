package lec.l15;

public class SinglyLinkedList<E> {

	private Node first;

	public E getFirst() {
		return first.data;
	}

	public int size() {
		int count = 0;
		Node temp = first;

		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void addFirst(E data) {
		first = new Node(data, first);
	}

	private class Node {
		private E data;
		private Node next;

		private Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
