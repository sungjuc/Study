package lec.l02;

import java.io.File;
import java.util.Scanner;

public class Input3 {
	public static void main(String[] args) throws Exception {
		int total = 0;
		int i = 0;

		Scanner file;
		file = new Scanner(new File("src/lec/l02/input.txt"));

		while (file.hasNext()) {
			i = file.nextInt();
			total = total + i;
		}

		System.out.println(total);
	}
}
