package lec.l13;

import junit.framework.TestCase;

public class SearchUtilsTest extends TestCase {
	int[] a;

	public void setUp() {
		a = new int[10000000];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}

	public void testSequentialContains() {
		long startTime = System.currentTimeMillis();
		assertTrue(SequentialSearchUtils.contains(a, 9999999));
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Sequential Search Time: " + timeTaken);
	}

	public void testBinaryContains() {
		long startTime = System.currentTimeMillis();
		assertTrue(BinarySearchUtils.contains(a, 9999999));
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Binary Search Time: " + timeTaken);
	}

}
