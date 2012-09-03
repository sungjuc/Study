package lec.l04;

import junit.framework.TestCase;

public class IntBoxTest extends TestCase {
	public void testBasic() {
		IntBox b = new IntBox(3);
		assertEquals(3, b.getValue());
	}

	public void testReference() {
		IntBox b1 = new IntBox(6);
		IntBox b2 = b1;

		b1.setValue(7);

		assertEquals(7, b1.getValue());
		assertEquals(7, b2.getValue());
	}
}
