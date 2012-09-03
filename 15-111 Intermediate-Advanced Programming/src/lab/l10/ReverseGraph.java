package lab.l10;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import java.util.Map.Entry;

public class ReverseGraph {

	public static void main(String[] args) throws Exception {
		System.out.print("Enter name of file with graph: ");
		String file = new Scanner(System.in).nextLine();
		File inputFile = new File("src/lab/l10/" + file);
		Map<String, Set<String>> originalGraph = ReverseGraph
				.processFile(inputFile);
		
		System.out.println();
		System.out.println("Graph: source -> {destination} edges");
		ReverseGraph.sortPrint(originalGraph);

		Map<String, Set<String>> reverseGraph = ReverseGraph
				.reverseGraph(originalGraph);

		System.out.println();
		System.out.println("Reverse Graph: source -> {destination} edges");
		ReverseGraph.sortPrint(reverseGraph);

	}

	public static Map<String, Set<String>> processFile(File inputFile)
			throws Exception {

		Scanner scanner = new Scanner(inputFile);
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		StringTokenizer tokens;

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			tokens = new StringTokenizer(line);
			Set<String> dest = new HashSet<String>();
			String source = null;
			while (tokens.hasMoreTokens()) {
				if (source != null) {
					if (!source.equals(tokens.nextToken()))
						throw new Exception("Source Data has corrupted!!!");
				} else {
					source = tokens.nextToken();
				}
				dest.add(tokens.nextToken());
			}
			graph.put(source, dest);
		}

		return graph;
	}

	public static Map<String, Set<String>> reverseGraph(
			Map<String, Set<String>> graph) {
		Map<String, Set<String>> reverseGraph = new HashMap<String, Set<String>>();
		Iterator<Entry<String, Set<String>>> it = graph.entrySet().iterator();
		String source;

		while (it.hasNext()) {
			Entry<String, Set<String>> entry = it.next();
			source = entry.getKey();
			Set<String> tempSet = entry.getValue();
			Iterator<String> setIt = tempSet.iterator();
			while (setIt.hasNext()) {
				String destination = setIt.next();
				Set<String> temp = null;
				if (reverseGraph.containsKey(destination)) {
					temp = reverseGraph.get(destination);

				} else {
					temp = new HashSet<String>();
				}
				temp.add(source);
				reverseGraph.put(destination, temp);
			}
		}

		return reverseGraph;
	}

	public static void sortPrint(Map<String, Set<String>> source) {
		List<Entry<String, Set<String>>> tempList = new ArrayList<Entry<String, Set<String>>>(
				source.entrySet());
		Collections.sort(tempList, ALPHABETICAL_ORDER);
		Iterator<Entry<String, Set<String>>> it = tempList.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public final static Comparator<Entry<String, Set<String>>> ALPHABETICAL_ORDER = new Comparator<Entry<String, Set<String>>>() {
		public int compare(Entry<String, Set<String>> e1,
				Entry<String, Set<String>> e2) {
			return e1.getKey().compareTo(e2.getKey());
		}
	};
}
