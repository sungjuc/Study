package lec.l08;

import java.util.ArrayList;

public class RecursionUtils {
	public static int iterativeCount(String word, String letter) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.substring(i, i + 1).equals(letter))
				count++;
		}
		return count;
	}

	public static int recursiveCount(String word, String letter) {
		if (word.length() == 0)
			return 0;
		else {
			int count = recursiveCount(word.substring(1), letter);
			if (letter.equals(word.substring(0, 1)))
				count++;
			return count;
		}
	}

	public static int iterativeCount(ArrayList<Integer> list, int n) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == n)
				count++;
		}

		return count;
	}

	public static int recursiveCount(ArrayList<Integer> list, int n) {
		return count(list, n, 0);
	}

	public static int count(ArrayList<Integer> list, int n, int index) {
		int count = 0;
		if (list.size() == index)
			return 0;
		else {
			count = count(list, n, index + 1);
			if (list.get(index) == n)
				count++;
			return count;
		}
	}
}
