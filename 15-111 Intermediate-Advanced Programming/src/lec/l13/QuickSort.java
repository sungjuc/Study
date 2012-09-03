package lec.l13;

import java.util.Arrays;

public class QuickSort {
	int[] numbers;

	public void quickSort(int[] numbers) {
		this.numbers = numbers;
		sortPartition(0, numbers.length - 1);
	}

	private int findPivot(int left, int right) {
		return ((left + right) / 2);
	}

	private void swapNumbers(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		System.out.println(Arrays.toString(numbers));
	}

	private int partition(int left, int right, int pivot) {
		do {
			while (numbers[++left] < numbers[pivot])
				;
			while ((right != 0) && (numbers[--right] > numbers[pivot]))
				;
			swapNumbers(left, right);
		} while (left < right);
		swapNumbers(left, right);
		return left;
	}

	private void sortPartition(int left, int right) {
		int pivot = findPivot(left, right);
		swapNumbers(pivot, right);
		int newPivot = partition(left - 1, right, right);
		swapNumbers(newPivot, right);

		if ((newPivot - left) > 1)
			sortPartition(left, newPivot - 1);
		if ((right - newPivot) > 1)
			sortPartition(newPivot + 1, right);
	}
}
