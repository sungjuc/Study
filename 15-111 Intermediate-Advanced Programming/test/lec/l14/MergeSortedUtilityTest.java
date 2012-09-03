package lec.l14;

import java.util.Arrays;

import junit.framework.TestCase;

public class MergeSortedUtilityTest extends TestCase {
	public void testMergeSortedList() {
		int[] numbers1 = new int[] { 1, 3, 7, 9, 11, 13 };
		int[] numbers2 = new int[] { 2, 4, 6, 10 };

		int[] mergedNumbers = MergeSortedUtility
				.mergeSorted(numbers1, numbers2);

		System.out.println(Arrays.toString(mergedNumbers));
	}
}
