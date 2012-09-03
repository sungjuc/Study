package lec.l29;

public class SimpleSet<E> implements Set<E> {
	private Node<E> head;
	private int size;

	public SimpleSet() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(Object obj) {
		Node<E> temp = head;
		
		while(temp != null) {
			if (temp.getData().equals(obj))
				return true;

			temp = temp.getNext();
		}
		return false;
	}

	public boolean add(E obj) {
		if(contains(obj))
			return false;
		head = new Node<E>(obj, head);
		size++;
		return true;
	}

	public boolean remove(Object obj) {
		Node<E> temp = head;
		Node<E> prev = null;
		
		while(temp != null) {
			if(temp.getData().equals(obj)) {
				if(prev == null)
					head = temp.getNext();
				else
					prev.setNext(temp.getNext());
				size--;
				return true;
			}
			
			prev = temp;
			temp = temp.getNext();
		}

		return false;
	}

	public Iterator<E> iterator() {
		return new SimpleSetIterator();
	}

	public String toString() {
		String result = "[ ";
		int count = 1;
		Node<E> temp = head;
		while (temp != null) {
			result += temp.getData();
			if (count++ != size)
				result +=", ";

			temp = temp.getNext();
		}

		return result + " ]";

	}

	private class SimpleSetIterator implements Iterator<E> {
		private Node<E> node;
	
		public SimpleSetIterator() {
			node = head;
		}

		public boolean hasNext() {
			return node != null;
		}

		public E next() {
			Node<E> current = node;
			node = node.getNext();
			return current.getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}