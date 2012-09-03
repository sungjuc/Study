package lec.l10;

import junit.framework.TestCase;

public class CardTest extends TestCase {
	public void testCard() {
		Card card = new Card(1, 3);
		assertEquals(1, card.getRank());
		assertEquals(3, card.getSuit());
	}
}
