package lec.l09;

import java.util.ArrayList;

import junit.framework.TestCase;

public class UtilsTest extends TestCase {
	ArrayList<Integer> list = new ArrayList<Integer>();
	ArrayList<Integer> dupList = new ArrayList<Integer>();

	public void setUp() {
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);

		dupList.add(2);
		dupList.add(2);
		dupList.add(3);
		dupList.add(3);
	}

	public void testCountValues() {
		assertEquals(4, Utils.countValues(list));
	}

	public void testGetLastValue() {
		assertEquals(4, Utils.getLastValue(list));
	}

	public void testMax() {
		assertEquals(4, Utils.max(list));
	}

	public void testContains() {
		assertTrue(Utils.contains(list, 1));
		assertFalse(Utils.contains(list, 0));
		assertTrue(Utils.contains(dupList, 3));
		assertFalse(Utils.contains(dupList, 4));
	}

	public void testHasDuplicates() {
		assertFalse(Utils.hasDuplicates(list));
		assertTrue(Utils.hasDuplicates(dupList));
	}

	public void testPow() {
		assertEquals(8, Utils.pow(2, 3));
		assertEquals(27, Utils.pow(3, 3));
	}
	
	public void testFastPow() {
		assertEquals(8, Utils.fastPow(2, 3));
		assertEquals(27, Utils.fastPow(3, 3));
	}
}
