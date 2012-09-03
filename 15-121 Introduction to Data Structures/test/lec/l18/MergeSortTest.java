package lec.l18;

import junit.framework.TestCase;

public class MergeSortTest extends TestCase {
	public void testInsertionSort() {
		int[] list = { 5, 4, 3, 2, 0, 1 };
		MergeSort.mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i]);
		System.out.println();
	}
}
