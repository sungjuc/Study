package lec.l07;

import junit.framework.TestCase;
import lec.l05.Node;

public class RecursionUtilsTest2 extends TestCase {
	public void testRecursion() {
		RecursionUtils.greet(2);
	}

	public void testFact() {
		assertEquals(2, RecursionUtils.fact(2));
		assertEquals(6, RecursionUtils.fact(3));
		assertEquals(24, RecursionUtils.fact(4));
	}

	public void testTwoFact() {
		assertEquals(2, RecursionUtils.twoFact(1));
		assertEquals(4, RecursionUtils.twoFact(2));
		assertEquals(8, RecursionUtils.twoFact(3));
		assertEquals(16, RecursionUtils.twoFact(4));
	}

	public void testSize() {
		Node list = new Node("1", new Node("2", new Node("3", null)));
		assertEquals(3, RecursionUtils.size(list));
	}

	public void testFib() {
		assertEquals(1, RecursionUtils.fib(1));
		assertEquals(1, RecursionUtils.fib(2));
		assertEquals(2, RecursionUtils.fib(3));
		assertEquals(3, RecursionUtils.fib(4));
		assertEquals(5, RecursionUtils.fib(5));
		assertEquals(8, RecursionUtils.fib(6));
	}

	public void testPow() {
		assertEquals(8, RecursionUtils.pow(2, 3));
		assertEquals(81, RecursionUtils.pow(3, 4));
	}
}
