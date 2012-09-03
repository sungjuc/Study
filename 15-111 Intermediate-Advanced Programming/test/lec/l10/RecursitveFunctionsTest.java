package lec.l10;

import junit.framework.TestCase;

public class RecursitveFunctionsTest extends TestCase {
	public void testPow2() {
		assertEquals(1, RecursiveFunctions.pow2(0));
		assertEquals(8, RecursiveFunctions.pow2(3));
		assertEquals(64, RecursiveFunctions.pow2(6));
	}

	public void testFactorial() {
		assertEquals(1, RecursiveFunctions.factorial(0));
		assertEquals(6, RecursiveFunctions.factorial(3));
		assertEquals(24, RecursiveFunctions.factorial(4));
	}

	public void testOops() {
		try {
			RecursiveFunctions.oops();
		} catch (Throwable e) {
			assertEquals(e.toString(), "java.lang.StackOverflowError");
		}
	}

	public void testBadFactorial() {
		try {
			RecursiveFunctions.badFactorial(1);
		} catch (Throwable e) {
			assertEquals(e.toString(), "java.lang.StackOverflowError");
		}
	}

	public void testfib() {
		assertEquals(1, RecursiveFunctions.fib(0));
		assertEquals(1, RecursiveFunctions.fib(1));
		assertEquals(2, RecursiveFunctions.fib(2));
		assertEquals(3, RecursiveFunctions.fib(3));
		assertEquals(5, RecursiveFunctions.fib(4));
		assertEquals(8, RecursiveFunctions.fib(5));
		assertEquals(13, RecursiveFunctions.fib(6));

	}

}
