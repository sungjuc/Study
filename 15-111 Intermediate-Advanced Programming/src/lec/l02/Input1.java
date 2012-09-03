package lec.l02;

import java.util.Scanner;

public class Input1 {
	public static void main(String[] args) {
		Scanner keyboard;

		keyboard = new Scanner(System.in);

		String input = "continue";

		while (!input.equals("Q")) {
			input = (String) keyboard.next();

			System.out.println(input);
		}

		System.out.println("We left the while loop");
	}
}
