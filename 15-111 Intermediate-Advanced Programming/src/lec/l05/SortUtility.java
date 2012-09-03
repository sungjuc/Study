package lec.l05;

public class SortUtility {
	public static void bubbleSort(int[] numbers) {
		for (int highest_unsorted = numbers.length - 1; highest_unsorted != 0; highest_unsorted--) {
			for (int best_so_far = 0; best_so_far < highest_unsorted; best_so_far++) {
				// printArrays(numbers);
				if (numbers[best_so_far] > numbers[best_so_far + 1])
					swapNumbers(best_so_far, best_so_far + 1, numbers);
			}
		}
	}

	public static void selectionSort(int[] numbers) {
		for (int seacherIndex = 0; seacherIndex < numbers.length - 1; seacherIndex++) {
			// printArrays(numbers);
			int correctIndex = seacherIndex;
			for (int candidateIndex = seacherIndex + 1; candidateIndex < numbers.length; candidateIndex++) {
				if (numbers[candidateIndex] < numbers[correctIndex]) {
					correctIndex = candidateIndex;
				}
			}
			swapNumbers(seacherIndex, correctIndex, numbers);
		}
	}

	public static void insertionSort(int[] numbers) {
		for (int insertMe = 1; insertMe < numbers.length; insertMe++) {
			// printArrays(numbers);
			for (int newPosn = 0; newPosn < insertMe; newPosn++) {
				if (numbers[insertMe] < numbers[newPosn]) {
					int temp = numbers[insertMe];
					for (int shift = insertMe; shift > newPosn;)
						numbers[shift] = numbers[--shift];
					numbers[newPosn] = temp;
					break;
				}
			}
		}
	}

	private static void swapNumbers(int i, int j, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static void printArrays(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println("");
	}
}
