package lec.l13;

import java.util.Arrays;

import junit.framework.TestCase;

public class QuickSortTest extends TestCase {
	public void testQuickSort() {
		checkQsSortValidity(new int[] { 5, 8, 1, 4, 3, 7, 6, 9, 11, 10, 12, 2 });
		checkQsSortValidity(new int[] { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		checkQsSortValidity(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
	}

	private void checkQsSortValidity(int[] numbers) {
		int[] sortedNumbers = numbers.clone();
		Arrays.sort(sortedNumbers);
		QuickSort qs = new QuickSort();
		qs.quickSort(numbers);
		assertTrue(Arrays.equals(sortedNumbers, numbers));
	}
}
