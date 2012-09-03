package lec.l16;

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

	public void addLastIterative(E data) {

		if (first == null)
			first = new Node(data, null);
		else {
			Node temp = first;
			while (temp.next != null)
				temp = temp.next;
			temp.next = new Node(data, null);
		}
	}

	public void addLastRecursive(E data) {
		first = addLast(first, data);
	}

	private Node addLast(Node list, E data) {
		if (list == null)
			return new Node(data, null);
		else {
			list.next = addLast(list.next, data);
			return list;
		}
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
