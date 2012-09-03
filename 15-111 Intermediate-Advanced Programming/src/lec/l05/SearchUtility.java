package lec.l05;

public class SearchUtility {
	public static boolean searchSortedIntArray(int findMe, int[] list,
			int beginIndex, int endIndex) {
		int middleIndex = beginIndex + (endIndex - beginIndex) / 2;

		if (findMe == list[middleIndex])
			return true;

		if ((findMe < list[middleIndex]) && (middleIndex > beginIndex)) {
			return searchSortedIntArray(findMe, list, beginIndex,
					middleIndex - 1);
		}
		if ((findMe > list[middleIndex]) && (middleIndex < endIndex)) {
			return searchSortedIntArray(findMe, list, middleIndex + 1, endIndex);
		}
		return false;
	}
}
