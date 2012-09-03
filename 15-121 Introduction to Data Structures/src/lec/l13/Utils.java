package lec.l13;

public class Utils {
	public static void flipAll(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = !arr[i];
		}
	}
}
