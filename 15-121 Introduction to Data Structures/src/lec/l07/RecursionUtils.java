package lec.l07;

import lec.l05.Node;

public class RecursionUtils {
	public static void mystery() {
		System.out.println();
		mystery();
	}

	public static void mystery(int n) {
		if (n > 0) {
			System.out.println("hello");
			mystery(n - 1);
		}
	}

	public static void greet(int n) {
		if (n == 0) {

		} else {
			System.out.println("hello");
			greet(n - 1);
		}
	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		} else {
			int result = fact(n - 1);
			return n * result;
		}
	}

	public static int twoFact(int n) {
		if (n == 0)
			return 1;
		else
			return 2 * twoFact(n - 1);
	}

	public static int size(Node list) {
		if (list == null)
			return 0;
		else
			return 1 + size(list.getNext());
	}

	public static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static int pow(int b, int n) {
		if (n == 0)
			return 1;
		else
			return b * pow(b, n - 1);
	}
}
