package lec.l14;

public class ArrayList<E> {
	private E[] values;
	private int size;

	public ArrayList() {
		values = (E[]) new Object[1];
		size = 0;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index " + index
					+ " is invalid for size " + size);
		else
			return values[index];
	}

	private void resizeIfFull() {
		if (size == values.length) {
			E[] bigger = (E[]) new Object[values.length * 2];
			for (int i = 0; i < values.length; i++) {
				bigger[i] = values[i];
			}
			values = bigger;
		}
	}

	public boolean add(E obj) {
		resizeIfFull();
		values[size] = obj;
		size++;
		return true;
	}

	public void add(int index, E obj) {
		resizeIfFull();
		for (int to = size; to > index; to--) {
			values[to] = values[to - 1];
		}
		values[index] = obj;
		size++;
	}
}
