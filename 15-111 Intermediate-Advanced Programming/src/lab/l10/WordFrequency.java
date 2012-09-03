package lab.l10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;

/**
 * Class read strings in file and print the strings value and its frequency.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 9
 * 
 */
public class WordFrequency {
	public static void main(String[] args) throws FileNotFoundException {
		WordFrequency wf = new WordFrequency();
		wf.printOutput();
	}

	/**
	 * Read Input file and fetch into map. Then, sort in alphabetical order and
	 * frequency order.
	 * 
	 * @throws FileNotFoundException
	 */
	public void printOutput() throws FileNotFoundException {
		File inputFile = new File("src/lab/l10/input1.txt");
		Scanner input = new Scanner(inputFile);
		StringTokenizer tokens = null;
		String line = null;
		Map<String, Integer> dataMap = new HashMap<String, Integer>();

		// Process the file and insert into map
		while (input.hasNextLine()) {
			line = input.nextLine();
			tokens = new StringTokenizer(line);
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				if (dataMap.containsKey(token))
					dataMap.put(token, dataMap.get(token) + 1);
				else
					dataMap.put(token, 1);
			}
		}

		// Print out the basic map.
		System.out.println("Map: ");
		System.out.println(dataMap);

		// Get list for sorting.
		List<Entry<String, Integer>> tempList = new ArrayList<Entry<String, Integer>>(
				dataMap.entrySet());
		System.out.println("List (sorted alphabetically): ");
		Collections.sort(tempList, ALPHABETICAL_ORDER);
		System.out.println(tempList);

		System.out.println("List (sorted by frequecy): ");
		Collections.sort(tempList, FREQUENCY_ORDER);
		System.out.println(tempList);
	}

	static final Comparator<Entry<String, Integer>> FREQUENCY_ORDER = new Comparator<Entry<String, Integer>>() {
		@Override
		public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
			return e1.getValue() - e2.getValue();
		}
	};

	static final Comparator<Entry<String, Integer>> ALPHABETICAL_ORDER = new Comparator<Entry<String, Integer>>() {
		@Override
		public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
			return e1.getKey().compareTo(e2.getKey());
		}
	};
}
