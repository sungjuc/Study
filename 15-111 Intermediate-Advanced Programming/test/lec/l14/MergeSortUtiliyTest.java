package lec.l14;

import java.util.Arrays;

import junit.framework.TestCase;

public class MergeSortUtiliyTest extends TestCase {

	public void testSort() {
		int[] numbers = new int[] { 1, 2, 7, 8, 6, 9, 10, 11 };
		System.out.println(Arrays.toString(numbers));
		MergeSortUtility.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
