package lec.l08;

import java.util.Scanner;

public class InputReverse {
	public static String input() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public static void reverse() {
		String s = input();
		if (s.length() == 0)
			return;
		else {
			reverse();
			System.out.println(s);
		}
	}
}
