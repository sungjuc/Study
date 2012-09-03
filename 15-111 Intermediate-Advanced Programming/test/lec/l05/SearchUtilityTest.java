package lec.l05;

import junit.framework.TestCase;

public class SearchUtilityTest extends TestCase {

	public void testSearchSortedIntArray() {
		int[] list = new int[] { 1, 2, 3, 4, 5 };
		assertTrue(SearchUtility.searchSortedIntArray(3, list, 0,
				list.length - 1));
		assertTrue(SearchUtility.searchSortedIntArray(2, list, 0,
				list.length - 1));
		assertTrue(SearchUtility.searchSortedIntArray(4, list, 0,
				list.length - 1));
		assertTrue(SearchUtility.searchSortedIntArray(5, list, 0,
				list.length - 1));
		assertTrue(SearchUtility.searchSortedIntArray(1, list, 0,
				list.length - 1));
		assertFalse(SearchUtility.searchSortedIntArray(9, list, 0,
				list.length - 1));
		assertFalse(SearchUtility.searchSortedIntArray(0, list, 0,
				list.length - 1));
	}
}
