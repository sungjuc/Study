package lec.l13;

public class BinarySearchUtils {
	public static boolean contains(int[] a, int value) {
		int lowIndex = 0;
		int highIndex = a.length - 1;
		while (lowIndex <= highIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			if (value == a[midIndex])
				return true;
			else if (value < a[midIndex])
				highIndex = midIndex - 1;
			else
				lowIndex = midIndex + 1;
		}
		return false;
	}
}
