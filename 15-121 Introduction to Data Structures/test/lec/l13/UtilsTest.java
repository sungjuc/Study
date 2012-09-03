package lec.l13;

import junit.framework.TestCase;

public class UtilsTest extends TestCase {
	boolean[] a;

	public void setUp() {
		a = new boolean[10000000];
		for (int i = 0; i < a.length; i++)
			a[i] = true;
	}

	public void testFllpAll() {
		Utils.flipAll(a);
		for (int i = 0; i < a.length; i++) {
			assertFalse(a[i]);
		}
	}
}
