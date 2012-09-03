package lec.l17;

import junit.framework.TestCase;

public class SortUtilsTest extends TestCase {
	public void testSelectionSort() {
		int[] list = { 5, 4, 3, 2, 0, 1 };
		SortUtils.selectionSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i]);
		System.out.println();
	}
	
	public void testInsertionSort() {
		int[] list = { 5, 4, 3, 2, 0, 1 };
		SortUtils.insertionSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i]);
		System.out.println();
	}
}
