package lec.l16;

public class LinkedList {

	private Node tail;
	private Node head;
	private int count;

	public LinkedList() {
		this.head = this.tail = null;
		this.count = 0;
	}

	public void addFirst(Object o) {
		this.head = new Node(o, this.head);
		if (tail == null)
			this.tail = head;
		count++;
	}

	public void addLast(Object o) {
		if (this.tail == null) {
			addFirst(o);
			return;
		}
		this.tail.setNext(new Node(o));
		this.tail = this.tail.getNext();
		count++;
	}

	public Object getFirst() {
		if (this.head == null)
			return null;
		return this.head.getItem();
	}

	public Object getLast() {
		if (this.tail == null)
			return null;
		return this.tail.getItem();
	}

	public Object getNth(int n) {
		int count;
		Node index = head;
		for (index = head, count = 0; count < n && index != null; index = index
				.getNext(), count++)
			;

		if (this.head == null)
			return null;

		return index.getItem();
	}

	public int indexOf(Object o) {
		int posn;
		Node index;
		for (index = head, posn = 0; ((index != null) && (!index.getItem()
				.equals(o))); index = index.getNext(), posn++)
			;

		if (posn > this.count - 1)
			return -1;

		return posn;
	}

	public boolean insertAtN(Object o, int n) {
		if (n < 0 || n > count)
			return false;

		if (n == 0) {
			addFirst(o);
			return true;
		}
		if (n == count) {
			addLast(o);
			return true;
		}

		int indexInt;
		Node indexNode;
		for (indexNode = head, indexInt = 0; ((indexNode != null) && (indexInt < n - 1)); indexNode = indexNode
				.getNext(), indexInt++)
			;

		indexNode.setNext(new Node(o, indexNode.getNext()));

		return true;
	}

	public boolean insertBefore(Object insertMe, Object beforeMe) {
		if (count == 0)
			return false;

		if (beforeMe.equals(head.getItem())) {
			addFirst(insertMe);
			return true;
		}

		Node index;

		for (index = head; (index.getNext() != null)
				&& (!index.getNext().getItem().equals(beforeMe)); index = index
				.getNext())
			;

		if (index.getNext() == null)
			return false;

		index.setNext(new Node(insertMe, index.getNext()));
		this.count++;

		return true;
	}

	public Object removeNth(int n) {
		Object saved;

		if ((n < 0) || (n >= count))
			return null;

		if (n == 0) {
			saved = head.getItem();
			head = head.getNext();
			count--;
			return saved;
		}

		Node indexNode;
		int i;

		for (i = 0, indexNode = head; i < (n - 1); i++, indexNode = indexNode
				.getNext())
			;
		saved = indexNode.getNext().getItem();
		count--;

		if (tail == indexNode.getNext())
			tail = indexNode;
		
		indexNode.setNext(indexNode.getNext().getNext());
		
		return saved;
	}

	private class Node {
		private Object item;
		private Node next;

		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}

		public Node(Object item) {
			this.item = item;
			this.next = null;
		}

		public Object getItem() {
			return this.item;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			if (this.next != null)
				return "[ " + this.item + ", " + this.next + " ]";
			else
				return "[ " + this.item + ", null ]";
		}

		public boolean equals(Node node) {
			if (!this.item.equals(node))
				return false;
			if (this.next != node.next)
				return false;
			return true;
		}
	}
}
