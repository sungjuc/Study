package exam.finale.exam4c.p2;

import exam.finale.exam4c.p1.Stamp;

/************************************************
 * Collection Class StampList
 * 
 * You are to implement a method named either insert or a method named remove
 * for this class as described in the exam instructions.
 * 
 * You may add additional helper (private) methods if you choose, but you may
 * NOT add additional public methods, nor may you change any methods that we
 * have already defined.
 * 
 * Name: Section: Date: 12/08/04 andrew e-mail:
 *************************************************/

public class StampList {
	/************************************************
	 * TO THE STUDENT: * USE THESE PRIVATE INSTANCE VARIABLES *
	 ************************************************/
	private Stamp[] values;
	private int numElements;

	/**
	 * Constructor: allocates an array of size 1 sets count to 0 does not
	 * construct any individual elements
	 */

	public StampList() {
		values = new Stamp[1];
		numElements = 0;
	}

	/************************************************
	 * TO THE STUDENT: IMPLEMENT THIS INSERT METHOD *
	 ************************************************/
	/**
	 * Inserts a value, newItem into the StampList at the position, atIndex, as
	 * follows: - if atIndex is invalid, (i.e., it is negative or greater than
	 * the current size of the array), display the message
	 * "INVALID INSERT: ?? is not a valid index" - the newItem should be placed
	 * into the list so that the list remains sorted by the appraised value.
	 * Other elements in the list should be shifted to the right by one
	 * position.
	 * 
	 * @param newItem
	 *            (Stamp) = what to be inserted into the StampList
	 * @param atIndex
	 *            (int) = where the new item is to be inserted
	 * @returns void
	 */
	public void insert(Stamp newItem, int atIndex) {
		if (atIndex > numElements || atIndex < 0) {
			System.out.println("INVALID INSERT: " + atIndex
					+ " is not a valid index");
			return;
		}

		if (numElements >= values.length)
			doubleLength();

		int index;
		for (index = numElements; index > atIndex; index--) {
			values[index] = values[index - 1];
		}
		values[index] = newItem;
		numElements++;
	}

	/************************************************
	 * TO THE STUDENT: IMPLEMENT THIS REMOVE METHOD *
	 ************************************************/
	/**
	 * This finds and removes that object with minimal appraised value from the
	 * collection class as specified below - if the array is not empty, this
	 * first finds the Stamp object in the collection class with the minimal
	 * appraised value - That object is removed and all other elements in the
	 * StampList should be shifted to the left by one position.
	 * 
	 * @returns void
	 * 
	 */
	public void remove() {
		if (numElements == 0)
			return;

		int lowest = 0;
		for (int i = 0; i < numElements; i++) {
			if (values[lowest].getAppraisedValue() > values[i]
					.getAppraisedValue())
				lowest = i;
		}

		for (int j = lowest + 1; j < numElements; j++) {
			values[j - 1] = values[j];
		}

		numElements--;
	}

	/************************************************
	 * TO THE STUDENT: * DO NOT MODIFY ANY CODE BELOW THESE COMMENTS *
	 ************************************************/
	/**
	 * Inserts the new item at the next available slot in the array, resizing
	 * the array as necessary.
	 * 
	 * @return void
	 */
	public void insertAtEnd(Stamp newItem) {
		if (numElements >= values.length)
			doubleLength();
		values[numElements++] = newItem;
	}

	/**
	 * Changes the array to have twice as many available cells All references in
	 * the original array are moved to the new array..
	 * 
	 * @return void
	 */
	public void doubleLength() {
		Stamp[] newA = new Stamp[values.length * 2];
		for (int i = 0; i < numElements; i++)
			newA[i] = values[i];
		values = newA;
	}

	/**
	 * Returns a string representing the entire contents of the StampList
	 * 
	 * @return this SList's string representation
	 */
	public String toString() {
		String result = "    StampList[" + "used=" + numElements + "/length="
				+ values.length + "\n";
		for (int i = 0; i < numElements; i++)
			result += "      values[" + i + "]= " + values[i] + "\n";
		return result + " ]";
	}
}
