package commons;

public class Utils {
	public static void swap(int[] array, int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	public static String arrayToString(int[] array) {
		String result = "[ ";
		for (int i = 0; i < array.length; i++) {
			result += array[i];
			if (i != array.length - 1) {
				result += ", ";
			}
		}
		result += " ]";

		return result;
	}
}