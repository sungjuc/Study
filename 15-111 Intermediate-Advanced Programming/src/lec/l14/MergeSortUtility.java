package lec.l14;

public class MergeSortUtility {
	public static void sort(int[] numbers) {
		if (numbers.length == 0)
			return;

		int[] temp = new int[numbers.length];
		mergeSort(numbers, temp, 0, numbers.length - 1);
	}

	public static void mergeSort(int[] numbers, int[] temp, int left, int right) {
		if (left >= right)
			return;

		int middle = (left + right) / 2;

		mergeSort(numbers, temp, left, middle);
		mergeSort(numbers, temp, middle + 1, right);

		merge(numbers, temp, left, middle + 1, right);
	}

	public static void merge(int[] numbers, int[] temp, int leftStart,
			int rightStart, int rightEnd) {
		int leftEnd = rightStart - 1;
		int leftPosition = leftStart;
		int rightPosition = rightStart;

		int tempPosition = leftPosition;

		while ((leftPosition <= leftEnd) && (rightPosition <= rightEnd)) {
			if (numbers[leftPosition] < numbers[rightPosition]) {
				temp[tempPosition++] = numbers[leftPosition++];
			} else {
				temp[tempPosition++] = numbers[rightPosition++];
			}
		}

		while (leftPosition <= leftEnd) {
			temp[tempPosition++] = numbers[leftPosition++];
		}

		while (rightPosition <= rightEnd) {
			temp[tempPosition++] = numbers[rightPosition++];
		}

		for (tempPosition = leftStart; tempPosition <= rightEnd; tempPosition++) {
			numbers[tempPosition] = temp[tempPosition];
		}
	}
}
