package lab.l10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Reachable {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.print("Enter name of file with graph: ");
		Scanner scanner = new Scanner(System.in);
		String fileName = "src/lab/l10/" + scanner.nextLine();
		File inputFile = new File(fileName);

		Map<String, Set<String>> graph = Reachable.getGraphFromFile(inputFile);

		System.out.println();
		System.out.println("Graph: source -> {destination} edges");
		Reachable.sortPrint(graph);

		System.out.println();
		System.out.println("Enter node to start from: ");
		String node = scanner.nextLine();

		Reachable.findAndPrintReachableNodes(graph, node);
	}

	public static void findAndPrintReachableNodes(
			Map<String, Set<String>> graph, String node) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> resultSet = new HashSet<String>();
		queue.add(node);

		while (queue.size() > 0) {
			String source = queue.remove();
			resultSet.add(source);
			if (graph.containsKey(source)) {
				Set<String> destinations = graph.get(source);
				Iterator<String> it = destinations.iterator();

				while (it.hasNext()) {
					String destination = it.next();
					if (!resultSet.contains(destination)
							&& !queue.contains(destination))
						queue.add(destination);
				}
			}
		}

		System.out.println(resultSet);
	}

	public static Map<String, Set<String>> getGraphFromFile(File inputFile)
			throws FileNotFoundException {
		Map<String, Set<String>> resultMap = new HashMap<String, Set<String>>();
		Scanner scanner = new Scanner(inputFile);
		String line = null;
		StringTokenizer tokens = null;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			tokens = new StringTokenizer(line);
			String source = null;
			Set<String> set = new HashSet<String>();

			while (tokens.hasMoreTokens()) {
				if (source == null)
					source = tokens.nextToken();
				else
					tokens.nextToken();
				set.add(tokens.nextToken());
			}

			resultMap.put(source, set);
		}

		return resultMap;
	}

	public static void sortPrint(Map<String, Set<String>> map) {
		List<Entry<String, Set<String>>> list = new ArrayList<Entry<String, Set<String>>>(
				map.entrySet());
		Collections.sort(list, ALPHABETICAL_ORDER);

		Iterator<Entry<String, Set<String>>> it = list.iterator();
		while (it.hasNext()) {
			Entry<String, Set<String>> entry = it.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public static final Comparator<Entry<String, Set<String>>> ALPHABETICAL_ORDER = new Comparator<Entry<String, Set<String>>>() {
		public int compare(Entry<String, Set<String>> e1,
				Entry<String, Set<String>> e2) {
			return e1.getKey().compareTo(e2.getKey());
		}
	};
}
