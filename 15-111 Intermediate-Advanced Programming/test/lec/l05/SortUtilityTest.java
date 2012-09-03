package lec.l05;

import java.util.Arrays;

import junit.framework.TestCase;

public class SortUtilityTest extends TestCase {
	public void testBubbleSort() {
		int[] numbers = { 9, 2, 1, 3, 6, 5, 4, 7 };
		int[] numbersCopy = numbers.clone();
		SortUtility.bubbleSort(numbers);
		Arrays.sort(numbersCopy);

		assertTrue(Arrays.equals(numbersCopy, numbers));
	}

	public void testSelectionSort() {
		int[] numbers = { 9, 2, 1, 3, 6, 5, 4, 7 };
		int[] numbersCopy = numbers.clone();
		SortUtility.selectionSort(numbers);
		Arrays.sort(numbersCopy);

		assertTrue(Arrays.equals(numbersCopy, numbers));
	}

	public void testInsertionSort() {
		int[] numbers = { 9, 2, 1, 3, 6, 5, 4, 7 };
		int[] numbersCopy = numbers.clone();
		SortUtility.insertionSort(numbers);
		Arrays.sort(numbersCopy);

		assertTrue(Arrays.equals(numbersCopy, numbers));
	}
}
