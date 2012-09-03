package lec.l02;

import java.util.Scanner;

public class Input2 {
	public static void main(String[] args) {
		int total = 0;
		int i = 0;

		Scanner keyboard;
		keyboard = new Scanner(System.in);

		while (i >= 0) {
			i = keyboard.nextInt();

			total = total + i;
			
			System.out.println(total);
		}

		System.out.println("We left the while loop");
	}
}
