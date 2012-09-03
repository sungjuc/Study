package lec.l04;

import java.util.ArrayList;

public class ArrayListUtils {
	public static int count(ArrayList<String> names, int numLetters) {
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() == numLetters)
				count++;
		}

		return count;
	}

	public static ArrayList<String> namesWithLength(ArrayList<String> names,
			int numLetters) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() == numLetters) {
				result.add(names.get(i));
			}
		}
		return result;
	}

	public static void removeNamesWithLengthWithProblem(
			ArrayList<String> names, int numLetters) {
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() == numLetters)
				names.remove(i);
		}
	}

	public static void removeNamesWithLength(ArrayList<String> names,
			int numLetters) {
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() == numLetters) {
				names.remove(i);
				i--;
			}
		}
	}

	public static void removeNamesWithLengthWithWhile(ArrayList<String> names,
			int numLetters) {
		int i = 0;
		while (i < names.size()) {
			if (names.get(i).length() == numLetters)
				names.remove(i);
			else
				i++;
		}
	}

	public static void removeNamesWithLengthWithBackLoop(
			ArrayList<String> names, int numLetters) {
		for (int i = names.size() - 1; i >= 0; i--) {
			if (names.get(i).length() == numLetters) {
				names.remove(i);
			}
		}
	}
}
