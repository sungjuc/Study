package lab.l07;

import java.util.Vector;

/**
 * The Class used to model a priority queue. Min-heap is implemented since the
 * smaller items have a higher priority.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 7
 */
public class Heap {
	private Vector<Comparable> list;

	/**
	 * Constructs the empty Heap. It will initialize the list and fill the first
	 * index with empty String. Therefore, the underlying list will starts from
	 * 1 index not 0 index.
	 */
	public Heap() {
		list = new Vector<Comparable>();
		list.add("");
	}

	/**
	 * Inserts the specified object into the Heap.
	 * 
	 * @param data
	 *            the data to be inserted.
	 */
	public void insert(Comparable data) {
		// Insert the data at the end of heap.
		list.add(data);

		// Adjust the heap sequence.
		if (list.size() - 1 > 1)
			swapUp(list.size() - 1);
	}

	/**
	 * Returns true if there are no objects stored within the Heap, otherwise
	 * false.
	 * 
	 * @return true if there are no objects stored within the Heap, otherwise
	 *         false.
	 */
	public boolean isEmpty() {
		// Return the result of list's empty check.
		return (list.size() == 1);
	}

	/**
	 * Removes the lowest valued element in the Heap.
	 * 
	 * @return the removed element.
	 * @throws HeapException
	 *             In case of exception, HeapException will be thrown.
	 */
	public Comparable removeMin() throws HeapException {
		if (list.size() == 1)
			throw new HeapException("Heap is empty");

		// Remove the root element.
		Comparable element = list.get(1);

		// If there is remaining data, just adjust the heap structure.
		if (list.size() > 2) {
			// Move to last element to the root element
			list.set(1, list.remove(list.size() - 1));

			// Recursively check.
			swapDown(1);
		} else {
			list.remove(1);
		}

		return element;
	}

	/**
	 * Swaps two elements in underlying Vector list.
	 * 
	 * @param pos1
	 *            the position
	 * @param pos2
	 *            the position
	 */
	private void swap(int pos1, int pos2) {
		Comparable temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}

	/**
	 * Adjusts the element to keep Heap. If the children elements are bigger
	 * than the specified element, it swap the parent with the least child and
	 * recursively call this. The complexity is O(log n).
	 * 
	 * @param position
	 *            the child element should be compared with its children.
	 */
	private void swapDown(int position) {
		// Base condition. If the position and its left child position is bigger
		// than the list size, return.
		if (position > list.size() - 1 || position * 2 > list.size() - 1) {
			return;
		}

		// Pick up the left and right position.
		int left = position * 2;
		int right = position * 2 + 1;

		int replace;

		// Pick up smaller element from child.
		if (right > list.size() - 1
				|| list.get(left).compareTo(list.get(right)) < 0) {
			replace = left;
		} else {
			replace = right;
		}

		// If the parent is bigger than the smaller element, replace it.
		if (list.get(position).compareTo(list.get(replace)) > 0) {
			swap(position, replace);
			swapDown(replace);
		}
	}

	/**
	 * Adjusts the element to keep Heap. If the parent element is bigger than
	 * the specified element, it swap the parent with child and recursively call
	 * this. The complexity is O(log n).
	 * 
	 * @param position
	 *            the child element should be compared with its parent.
	 */
	private void swapUp(int position) {
		// If the position is smaller than 1, throw exception.
		if (position < 1) {
			throw new IllegalArgumentException();
		}

		// Base condition
		if (position == 1) {
			return;
		}

		// Recursively compare the element with its parent and swap if the
		// parent is bigger than its child.
		if (list.get(position / 2).compareTo(list.get(position)) > 0) {
			swap(position / 2, position);
			swapUp(position / 2);
		} else {
			// If the parent is smaller than child. It is done. just return.
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i < list.size(); i++) {
			result += " " + list.get(i);
		}
		return result;
	}
}
