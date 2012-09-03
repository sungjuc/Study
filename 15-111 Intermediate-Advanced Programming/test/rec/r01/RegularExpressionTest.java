package rec.r01;

import junit.framework.TestCase;

public class RegularExpressionTest extends TestCase {
	public void testCheckUpto10LettersAndAYear() {
		assertTrue(RegularExpression.checkUpto10LettersAndAYear("a 1973"));
		assertTrue(RegularExpression.checkUpto10LettersAndAYear("aaaaaggggg 9999"));
		assertFalse(RegularExpression.checkUpto10LettersAndAYear("1 1973"));
		assertFalse(RegularExpression.checkUpto10LettersAndAYear("a1973"));
		assertFalse(RegularExpression.checkUpto10LettersAndAYear("aaaaagggggg 9999"));
		assertFalse(RegularExpression.checkUpto10LettersAndAYear("aaaaaggggg 99999"));
	}
	public void testCheckPhoneNumber() {
		assertTrue(RegularExpression.checkPhoneNumber("1-123-333-1199"));
		assertTrue(RegularExpression.checkPhoneNumber("1-222-333-1199"));
		assertTrue(RegularExpression.checkPhoneNumber("82-2-583-1561"));
		assertTrue(RegularExpression.checkPhoneNumber("82-11-9713-1561"));
		assertFalse(RegularExpression.checkPhoneNumber("82-11-9713-XXXX"));
	}
}
