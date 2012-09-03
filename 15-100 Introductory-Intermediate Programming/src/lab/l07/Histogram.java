package lab.l07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;

/**
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 7
 */
public class Histogram {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter the name of file of words: ");
		Scanner keyboard = new Scanner(System.in);
		String filename = keyboard.next();
		Map<String, Integer> map = null;

		try {
			map = readFile(filename);
			System.out.println("Map: ");
			System.out.println(map.toString());
			System.out.println();

			List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
					map.entrySet());
			Collections.sort(list, new Histogram.keyComparator());

			System.out.println("List: ");
			System.out.println(list.toString());
			System.out.println();

			Collections.sort(list, new Histogram.valueComparator());

			System.out.println("List: ");
			System.out.println(list.toString());
		} catch (FileNotFoundException fnfe) {
			System.out.println("The file is not valid.");
		}
	}

	/**
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Map<String, Integer> readFile(String filename)
			throws FileNotFoundException {
		Scanner file = new Scanner(new File(filename));
		Map<String, Integer> map = new HashMap<String, Integer>();

		while (file.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(file.nextLine());
			while (st.hasMoreElements()) {
				String word = st.nextToken();
				int value = 1;
				if (map.containsKey(word)) {
					value = map.get(word) + 1;
				}
				map.put(word, value);
			}
		}

		return map;
	}

	/**
	 * @author sungju.cho
	 * 
	 */
	public static class keyComparator implements
			Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o1.getKey().compareTo(o2.getKey());
		}
	}

	/**
	 * @author sungju.cho
	 * 
	 */
	public static class valueComparator implements
			Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o2.getValue() - o1.getValue();
		}
	}
}
