package lec.l10;

public class RecursiveFunctions {

	public static int pow2(int n) {
		if (n == 0)
			return 1;
		return 2 * pow2(n - 1);
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public static void oops() {
		oops();
	}

	public static int badFactorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n + 1);
	}

	public static int fib(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}
