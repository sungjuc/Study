package exam.e03.a;

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
	 * TO THE STUDENT: * Write the toString() method here *
	 ************************************************/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++)
			sb.append(items[i]).append("\n");
		return sb.toString();
	}

	/************************************************
	 * TO THE STUDENT: * Write the mergeAlternate method here *
	 ************************************************/
	public Container mergeAlternate(Container otherContainer) {
		Container merged = new Container(count + otherContainer.count);
		int counter = count > otherContainer.count ? count
				: otherContainer.count;
		
		for (int i = 0; i < counter; i++) {
			if (counter <= count)
				merged.insertAtEnd(items[i]);

			if (counter <= otherContainer.count)
				merged.insertAtEnd(otherContainer.items[i]);

		}
		
		return merged;
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
