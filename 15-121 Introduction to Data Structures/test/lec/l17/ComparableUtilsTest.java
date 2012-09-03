package lec.l17;

import junit.framework.TestCase;

public class ComparableUtilsTest extends TestCase {
	public void testMax() {
		assertEquals(2, ComparableUtils.max(1, 2));
		assertEquals("x", ComparableUtils.max("a", "x"));

		String result = (String) ComparableUtils.max("x", "y");
		assertEquals("y", result);

		try {
			ComparableUtils.max(new Integer(3), "four");
		} catch (Exception e) {
			assertTrue(e instanceof ClassCastException);
		}

	}
}
