package lec.l19;

import commons.Utils;

public class QuickSort {

	public static void main(String[] args) {
		// Test for partition method
		System.out.println("Partition Test");
		int[] test = { 4, 1, 5, 2, 7, 3 };
		System.out.println(Utils.arrayToString(test));
		QuickSort.partition(test, 0, test.length - 1);
		System.out.println(Utils.arrayToString(test));

		System.out.println();
		System.out.println("Quick Sort Test");

		int[] test2 = { 4, 1, 5, 2, 7, 3 };
		QuickSort.quickSort(test2);
		System.out.println(Utils.arrayToString(test2));

	}

	public static void quickSort(int[] a) {
		QuickSort.quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivot = QuickSort.partition(a, low, high);
			QuickSort.quickSort(a, low, pivot - 1);
			QuickSort.quickSort(a, pivot + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		int rightIndex = low + 1;

		for (int i = low + 1; i <= high; i++) {
			if (a[i] < pivot) {
				Utils.swap(a, i, rightIndex);
				rightIndex++;
			}
		}

		Utils.swap(a, low, rightIndex - 1);
		return rightIndex - 1;
	}

}