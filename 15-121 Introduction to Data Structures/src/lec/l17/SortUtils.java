package lec.l17;

public class SortUtils {
	private static int indexOfMin(int[] a, int start) {
		int minIndex = start;
		for (int i = start; i < a.length; i++) {
			if (a[i] < a[minIndex])
				minIndex = i;
		}
		return minIndex;
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIndex = indexOfMin(a, i);
			int temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
	}

	private static void insert(int[] a, int index) {
		int toInsert = a[index];
		while (index > 0 && a[index - 1] > toInsert) {
			a[index] = a[index - 1];
			index--;
		}
		a[index] = toInsert;
	}

	public static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			insert(a, i);
		}
	}
}
