package lec.l18;

public class MergeSort {
	public static void mergeSort(int[] a) {
		if (a.length > 1) {
			int mid = a.length / 2;
			int[] left = subArray(a, 0, mid - 1);
			int[] right = subArray(a, mid, a.length - 1);
			mergeSort(left);
			mergeSort(right);
			merge(left, right, a);
		}
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (rightIndex == right.length
					|| (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
				a[i] = left[leftIndex];
				leftIndex++;
			} else {
				a[i] = right[rightIndex];
				rightIndex++;
			}
		}
	}

	private static int[] subArray(int[] a, int low, int high) {
		int sub[] = new int[high - low + 1];
		for (int i = 0; i < sub.length; i++)
			sub[i] = a[low + i];
		return sub;
	}
}
