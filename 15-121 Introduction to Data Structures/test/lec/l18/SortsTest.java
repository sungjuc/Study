package lec.l18;

import junit.framework.TestCase;
import lec.l17.SortUtils;

public class SortsTest extends TestCase {
	int[] list;
	final int size = 1000000;

	long startTime;
	long endTime;

	public void setUp() {
		list = new int[size];
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = size - i;
		}
	}

	public void testMmergeSort() {
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(list);
		endTime = System.currentTimeMillis();
		System.out.println("MergeSort time taken: " + (endTime - startTime));
	}

	public void testSelectionSort() {
		startTime = System.currentTimeMillis();
		SortUtils.selectionSort(list);
		endTime = System.currentTimeMillis();
		System.out.println("SelectonSort time taken: " + (endTime - startTime));
	}

	public void testInsertionSort() {
		startTime = System.currentTimeMillis();
		SortUtils.insertionSort(list);
		endTime = System.currentTimeMillis();
		System.out
				.println("InsertionSort time taken: " + (endTime - startTime));
	}
}
