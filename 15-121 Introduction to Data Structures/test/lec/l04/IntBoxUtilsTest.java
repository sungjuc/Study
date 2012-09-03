package lec.l04;

import junit.framework.TestCase;

public class IntBoxUtilsTest extends TestCase {
	public void testNewChange() {
		IntBox b = new IntBox(3);
		assertEquals(3, b.getValue());
		IntBoxUtils.newChange(b, 5);
		assertEquals(5, b.getValue());
	}
	
	public void testChange() {
		IntBox b = new IntBox(3);
		IntBoxUtils.change(b, 5);
		assertEquals(3, b.getValue());
	}

	public void testReplace() {
		IntBox b = new IntBox(3);
		assertEquals(3, b.getValue());
		b = new IntBox(5);
		assertEquals(5, b.getValue());
	}
}
