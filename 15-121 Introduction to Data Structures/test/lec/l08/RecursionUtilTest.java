package lec.l08;

import java.util.ArrayList;

import junit.framework.TestCase;

public class RecursionUtilTest extends TestCase {
	ArrayList<Integer> list = new ArrayList<Integer>();

	public void setUp() {
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
	}

	public void testIterativeCount() {
		assertEquals(5, RecursionUtils.iterativeCount("aaabcccccccbaa", "a"));
		assertEquals(2, RecursionUtils.iterativeCount("aaabcccccccbaa", "b"));
		assertEquals(7, RecursionUtils.iterativeCount("aaabcccccccbaa", "c"));
	}

	public void testRecursiveCount() {
		assertEquals(5, RecursionUtils.recursiveCount("aaabcccccccbaa", "a"));
		assertEquals(2, RecursionUtils.recursiveCount("aaabcccccccbaa", "b"));
		assertEquals(7, RecursionUtils.recursiveCount("aaabcccccccbaa", "c"));
	}

	public void testInterativeCountArrayList() {
		assertEquals(1, RecursionUtils.iterativeCount(list, 1));
		assertEquals(2, RecursionUtils.iterativeCount(list, 2));
		assertEquals(3, RecursionUtils.iterativeCount(list, 3));
	}
	
	public void testRecursiveCountArrayList() {
		assertEquals(1, RecursionUtils.recursiveCount(list, 1));
		assertEquals(2, RecursionUtils.recursiveCount(list, 2));
		assertEquals(3, RecursionUtils.recursiveCount(list, 3));
	}
}
