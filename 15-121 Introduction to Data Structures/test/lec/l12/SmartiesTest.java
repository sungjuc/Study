package lec.l12;

import junit.framework.TestCase;

public class SmartiesTest extends TestCase {
	public void testPlay() {
		Smarties.play(new RandomPlayer(), new SimplePlayer(), 5);
	}
}
