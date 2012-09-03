package lec.l04;

import java.util.Scanner;

public class ArrayStuff {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String[] names;

		System.out.println("How many names? ");
		int numberOfNames = keyboard.nextInt();
		names = new String[numberOfNames];
		keyboard.nextLine();

		for (int nameIndex = 0; nameIndex < numberOfNames; nameIndex++) {
			System.out.println("Name: ");
			names[nameIndex] = keyboard.nextLine();
		}

		System.out.println("");
		System.out.println("Names in reverse:");

		for (int nameIndex = (numberOfNames - 1); nameIndex >= 0; nameIndex--) {
			System.out.println(names[nameIndex]);
		}

		System.out.println("Just printed " + names.length + " names.");
	}
}
