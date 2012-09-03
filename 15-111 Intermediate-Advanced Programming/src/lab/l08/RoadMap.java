package lab.l08;

import java.io.*;
import java.util.*;

/**
 * This class models a collection fo cities and roads. It uses two graphs. One
 * which keeps the distance of the roads in miles as the cost of the edges. The
 * other of which keeps the expected travel time, in minutes, as the cost of the
 * edges.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 8
 */
class RoadMap {

	/**
	 * This class should contain a vertex's entry in the table used by
	 * Dijkstra's algorithm. Basically, it should be a row of this table (path,
	 * distance, known). It should also contain conveniences such as toString()
	 * You shoudl write this...
	 * 
	 * @author sungju.cho
	 */
	public class DijTableEntry {
		// Basic member variables.
		int path;
		int cost;
		boolean known;

		public DijTableEntry() {
			this.path = -1;
			this.known = false;
			this.cost = Integer.MAX_VALUE;
		}

		public String toString() {
			return "Known: " + this.known + "\tPath: " + this.path + "\tCost: "
					+ this.cost;
		}
	}

	private DataReader mapFile; // File abstraction for input file
	private String cityName[]; // City number to name mapping table
	private AdjList distanceMap; // Graph representing map w/cost as distance
	private AdjList timeMap; // Graph representing map w/cost as travel time

	/*
	 * Helper method to return city's number, given its name The reverse mapping
	 * is done by indexing into the table
	 */
	private int getCityNumber(String givenCityName) {
		for (int index = 0; index < cityName.length; index++) {
			if (cityName[index].equals(givenCityName))
				return index;
		}

		return -1;
	}

	/*
	 * This creates the distanceMap and timeMap from a properly formatted input
	 * file
	 */
	public RoadMap(String mapFileName) {
		try {
			mapFile = new DataReader(mapFileName);
			int numCities = mapFile.readInt();

			distanceMap = new AdjList(numCities);
			timeMap = new AdjList(numCities);
			cityName = new String[numCities];

			// Read city names into name:number mapping
			for (int index = 0; index < numCities; index++)
				cityName[index] = mapFile.readWord();
		} catch (Exception e) {
			// An error -- not much to do.
			System.out.println(e);
			return;
		}

		try {
			while (true) {
				String startCity = mapFile.readWord();
				String destinationCity = mapFile.readWord();

				int distance = mapFile.readInt();
				int time = mapFile.readInt();

				distanceMap.addEdge(new Edge(getCityNumber(startCity),
						getCityNumber(destinationCity), distance));
				timeMap.addEdge(new Edge(getCityNumber(startCity),
						getCityNumber(destinationCity), time));
			}
		} catch (EOFException e) {
		} // Normal exit -- no more roads to map

		catch (Exception e) {
			// A real error -- not much to do.
			System.out.println(e);
			System.exit(-1);
		}

		for (String city : cityName)
			System.out.println(city);
	}

	/**
	 * Determines the path from start to each other vertex using Dijkstra's
	 * algorithm. This method store the result in table. With start and
	 * distanceNotTime parameter, it generates the table with start position
	 * with shortest or fastest criteria.
	 * 
	 * @param start
	 *            the name of start city.
	 * @param distanceNotTime
	 *            true is distance. Otherwise, time.
	 * @return the table containing the path from start to each other vertex.
	 */
	public DijTableEntry[] dijkstra(String start, boolean distanceNotTime) {
		/*
		 * sYou should write this. It should implement Dijkstra's algorithm to
		 * determine the path from start to each other vertex. This path should
		 * be stored (with distance) in a table, as we did in class. This table
		 * is represented as an array of DijTableEntry with one entry (row) per
		 * vertex.
		 * 
		 * "distanceNotTime" is a boolean that indicates that the which of the
		 * two map files should be used: distance if true, time if false.
		 * 
		 * "start" is the name of the start city.
		 */
		// Initialize the result table, queue and list.
		DijTableEntry[] dijTable = initDijTableEntry();
		Integer startNumber = this.getCityNumber(start);
		DijTableEntry startEntry = dijTable[startNumber];
		startEntry.cost = 0;
		startEntry.path = startNumber;
		startEntry.known = true;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10,
				new EntryComparator(dijTable));
		queue.add(startNumber);

		AdjList list;
		if (distanceNotTime)
			list = this.distanceMap;
		else
			list = this.timeMap;

		// Breadth first search
		while (queue.size() > 0) {
			Integer fromNumber = queue.poll();
			DijTableEntry from = dijTable[fromNumber];
			from.known = true;
			Iterator it = list.getAdjacencies(fromNumber);
			while (it.hasNext()) {
				Edge edge = (Edge) it.next();
				DijTableEntry to = dijTable[edge.getDestinationVertex()];
				if (!to.known) {
					if (to.cost > dijTable[fromNumber].cost + edge.getCost()) {
						to.cost = dijTable[fromNumber].cost + edge.getCost();
						to.path = fromNumber;
					}
					queue.add(edge.getDestinationVertex());
				}
			}
		}

		// return dijTable;
		return dijTable;
	}

	/**
	 * Class for the priority queue comparator.
	 * 
	 * @author sungju.cho
	 * 
	 */
	private class EntryComparator implements Comparator {
		private DijTableEntry[] resultTable;

		public EntryComparator(DijTableEntry[] dijTable) {
			this.resultTable = dijTable;
		}

		@Override
		public int compare(Object obj1, Object obj2) {
			Integer int1 = (Integer) obj1;
			Integer int2 = (Integer) obj2;
			return resultTable[int1].cost - resultTable[int2].cost;
		}

	}

	private DijTableEntry[] initDijTableEntry() {
		DijTableEntry[] table = new DijTableEntry[cityName.length];
		for (int i = 0; i < table.length; i++) {
			table[i] = new DijTableEntry();
		}
		return table;
	}

	/**
	 * Prints out the path from start to finish. Since the table entry is
	 * already created from start point, this method doesn't need start point.
	 * 
	 * @param dijTable
	 *            the entry table from Dijkstra's algorithm with starting point.
	 * @param finish
	 *            the finish city.
	 */
	public void printPath(DijTableEntry[] dijTable, String finish) {
		Stack<DijTableEntry> result = new Stack<DijTableEntry>();
		Stack<Integer> resultIndex = new Stack<Integer>();
		DijTableEntry entry;

		// Get the finish index
		int index = this.getCityNumber(finish);

		// Find the path until it find the cost 0 or there is no path
		do {
			// Get entry
			entry = dijTable[index];

			// If the path is unknown, it is impossible to calculating route.
			if (!entry.known) {
				System.out
						.println("==============================================");
				System.out.println("It is impossible to caculate from "
						+ findStart(dijTable) + " to " + finish + "!!!");
				System.out
						.println("==============================================");
				return;
			}

			if (entry.cost != 0) {
				// Store the entry into stack.
				result.push(entry);
				resultIndex.push(index);
			}

			// Update index of entry
			index = entry.path;
		} while (entry.cost != 0);
		System.out.println("==============================================");
		System.out.println("Route from " + this.findStart(dijTable) + " to "
				+ finish + ": ");
		System.out.println("----------------------------------------------");
		int prevTotalCost = 0;
		// Iterate the result stack and print the result.
		while (!result.isEmpty()) {
			DijTableEntry resultEntry = result.pop();
			int cost = resultEntry.cost;
			// System.out.println(resultEntry.toString());
			System.out.println(this.cityName[resultEntry.path] + " - "
					+ this.cityName[resultIndex.pop()] + " : "
					+ (cost - prevTotalCost));
			prevTotalCost = cost;
		}
		System.out.println("----------------------------------------------");
		System.out.println("Total: " + prevTotalCost);
		System.out.println("==============================================");
	}

	/**
	 * Finds the start point from entry table.
	 * 
	 * @param dijTable
	 *            the entry table from Dijkstra's algorithm with starting point.
	 * @return the start city name.
	 */
	private String findStart(DijTableEntry[] dijTable) {
		int index = -1;
		for (int i = 0; i < dijTable.length; i++) {
			if (dijTable[i].cost == 0) {
				index = i;
				break;
			}
		}
		return this.cityName[index];
	}

	/*
	 * This is a really simple method. Please feel free to do something nicer
	 */
	public String toString() {
		return "Distance\n\n" + distanceMap.toString() + "\n\n" + "Time\n\n"
				+ timeMap.toString() + "\n\n";

	}

	/**
	 * Test driver demonstrating that the code can produce the shortest route
	 * and the quickest route between any pair of cities from a map.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String mapFile = "src/lab/l08/sampleMap.txt";
		RoadMap roadMap = new RoadMap(mapFile);

		DijTableEntry[] resultTable = roadMap.dijkstra("Atlanta", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		resultTable = roadMap.dijkstra("Charleston", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		resultTable = roadMap.dijkstra("Pittsburgh", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		resultTable = roadMap.dijkstra("Philadelphia", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		resultTable = roadMap.dijkstra("DC", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		// The map from the lecture 26.
		mapFile = "src/lab/l08/testMap.txt";
		roadMap = new RoadMap(mapFile);

		resultTable = roadMap.dijkstra("1", false);

		roadMap.printPath(resultTable, "1");
		roadMap.printPath(resultTable, "2");
		roadMap.printPath(resultTable, "3");
		roadMap.printPath(resultTable, "4");
		roadMap.printPath(resultTable, "5");
		roadMap.printPath(resultTable, "6");
		roadMap.printPath(resultTable, "7");
	}
}
