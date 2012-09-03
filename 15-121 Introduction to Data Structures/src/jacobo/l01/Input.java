package jacobo.l01;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("enter your age: ");
		int age = Integer.parseInt(keyboard.next());
		System.out.println("you are " + age + " years old.");
	}
}
