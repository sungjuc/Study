package lec.l04;

public class Container {
	private Object[] items;
	private int count;

	private static final int DEFAULT_SIZE = 10;
	private static final int GROWTH_COEFF = 2;

	public Container() {
		items = new Object[DEFAULT_SIZE];
		count = 0;
	}

	public Container(int size) {
		items = new Object[size];
		count = 0;
	}

	public void add(Object item) {
		if (count == items.length)
			grow();
		items[count++] = item;
	}

	public void grow() {
		Object[] biggerArray = new Object[GROWTH_COEFF * items.length];
		for (int index = 0; index < items.length; index++)
			biggerArray[index] = items[index];
		items = biggerArray;
	}
}
