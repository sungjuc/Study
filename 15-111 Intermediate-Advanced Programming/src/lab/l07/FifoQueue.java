package lab.l07;

import java.util.LinkedList;

/**
 * The Class used to model a First-In-First-Out queue. LinkedList is used to
 * implement this class.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 7
 */
public class FifoQueue {
	private LinkedList<Comparable> list;

	/**
	 * Constructs the FifoQueue instance with initializing an empty FifoQueue.
	 */
	public FifoQueue() {
		// Initialize the list instance.
		list = new LinkedList<Comparable>();
	}

	/**
	 * Returns true if there are no objects stored within the FifoQueue,
	 * otherwise, false.
	 * 
	 * @return true if there are no objects stored within the FifoQueue,
	 *         otherwise, false.
	 */
	public boolean isEmpty() {
		// Return the list's isEmpty result.
		return list.isEmpty();
	}

	/**
	 * Inserts the specified object at the end/tail of the FifoQueue.
	 * 
	 * @param data
	 *            the object to be inserted.
	 */
	public void insert(Comparable data) {
		list.add(data);
	}

	/**
	 * Removes the oldest element from the head of the FifoQueue.
	 * 
	 * @return the removed element.
	 */
	public Comparable removeMin() {
		// Return the first element.
		return list.removeFirst();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return list.toString();
	}
}
