package lec.l11;

import junit.framework.TestCase;

public class SmartiesTest extends TestCase {
	public void testPlay() {
		Smarties.play(new SimplePlayer(), new RandomPlayer(), 5);
	}
}
