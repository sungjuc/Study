package lec.l14;

public class MergeSortedUtility {

	public static int[] mergeSorted(int[] numbers1, int[] numbers2) {
		int count1 = numbers1.length;
		int count2 = numbers2.length;
		int[] mergedNumbers = new int[count1 + count2];

		int index1 = 0;
		int index2 = 0;
		int indexM = 0;

		while (index1 < count1 && index2 < count2) {
			if (numbers1[index1] < numbers2[index2]) {
				mergedNumbers[indexM++] = numbers1[index1++];
			} else {
				mergedNumbers[indexM++] = numbers2[index2++];
			}
		}

		while (index1 < count1) {
			mergedNumbers[indexM++] = numbers1[index1++];
		}

		while (index2 < count2) {
			mergedNumbers[indexM++] = numbers2[index2++];
		}
		return mergedNumbers;
	}
}
