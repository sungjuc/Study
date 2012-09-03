package lec.l09;

import java.util.ArrayList;

public class Utils {
	public static int countValues(ArrayList<Integer> list) {
		return list.size();
	}

	public static int getLastValue(ArrayList<Integer> list) {
		return list.get(list.size() - 1);
	}

	public static int max(ArrayList<Integer> list) {
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max)
				max = list.get(i);
		}
		return max;
	}

	public static boolean contains(ArrayList<Integer> list, int value) {
		return contains(list, value, 0);
	}

	public static boolean contains(ArrayList<Integer> list, int value, int index) {
		if (index == list.size())
			return false;
		if (value == list.get(index))
			return true;
		return contains(list, value, index + 1);
	}

	public static boolean hasDuplicates(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++)
			if (contains(list, list.get(i), i + 1))
				return true;
		return false;
	}

	public static int pow(int b, int n) {
		if (n == 0)
			return 1;
		else
			return b * pow(b, n - 1);
	}

	public static int fastPow(int b, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			int temp = fastPow(b, n / 2);
			return temp * temp;
		} else {
			return b * fastPow(b, n - 1);
		}
	}
}
