package lec.l13;

public class SequentialSearchUtils {
	public static boolean contains(int[] a, int value) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value)
				return true;
		}
		return false;
	}
}
