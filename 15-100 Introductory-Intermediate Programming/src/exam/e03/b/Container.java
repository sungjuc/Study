package exam.e03.b;

import java.util.Arrays;

public class Container {
	private Comparable[] items;
	private int count;

	public Container() {
		items = new Comparable[1];
		count = 0;
	}

	public Container(int length) {
		items = new Comparable[length];
		count = 0;
	}

	/************************************************
	 * TO THE STUDENT: * Write your toString method here *
	 ************************************************/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append(items[i]).append("\n");
		return sb.toString();
	}

	/************************************************
	 * TO THE STUDENT: * Write your sortedHalfXor method here *
	 ************************************************/
	public Container sortedHalfXor(Container otherContainer) {
		Container sortedHalfXor = new Container();
		boolean isItemsInOtherContainer;
		for (int i = 0; i < count; i++) {
			isItemsInOtherContainer = false;
			for (int j = 0; j < otherContainer.count; j++) {
				if (items[i].equals(otherContainer.items[j])) {
					isItemsInOtherContainer = true;
					break;
				}
			}
			if (!isItemsInOtherContainer)
				sortedHalfXor.insertAtEnd(items[i]);
		}

		Arrays.sort(sortedHalfXor.items, 0, sortedHalfXor.count - 1);
		return sortedHalfXor;
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
	public void insertAtEnd(Comparable newItem) {
		if (count >= items.length)
			doubleLength();

		items[count] = newItem;
		count++;
	}

	/**
	 * Changes the array to have twice as many available cells as it has now.
	 * All references in the original array are moved to the new array.
	 * 
	 * @return void
	 */
	private void doubleLength() {
		Comparable[] newArray = new Comparable[items.length * 2];
		for (int i = 0; i < count; i++)
			newArray[i] = items[i];
		items = newArray;
	}

}
