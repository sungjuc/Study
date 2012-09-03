package lab.l09;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class contains the sidewalks calculation application. This class create its
 * instance with reading the input file and parse the file into adjacent list.
 * Then, the adjacent list will be used to calculate the minimum spanning tree
 * and finally it will be printed out in this class.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 9
 */
public class SideWalks {
	private List<Coordinate> landMarkList;
	private AdjList distanceMap;
	private PriorityQueue<Edge> queue;

	/**
	 * Construct the adjacent list file from input file. Then, it creates the
	 * edge based on the adjacent list and store them in the priority queue.
	 * 
	 * @param mapFile
	 *            the map contains the vertices and positions.
	 */
	public SideWalks(String mapFile) {
		DataReader mapReader = null;

		// Prepare the map reader.
		try {
			mapReader = new DataReader(mapFile);
		} catch (Exception e) {
			// An error -- not much to do.
			System.out.println(e);
			return;
		}

		landMarkList = new ArrayList<Coordinate>();
		queue = new PriorityQueue<Edge>(10, new DistanceComparator());

		// Read the line from map.
		try {
			String line;
			while ((line = mapReader.readLine()) != "") {
				String[] data = line.split(" ");
				landMarkList.add(new Coordinate(data[0], data[1]));
			}
		} catch (EOFException e) {
			// Normal exit. No more landmarks.
		} catch (IOException e) {
			// A real error -- not much to do.
			System.out.println(e);
			System.exit(-1);
		}

		distanceMap = new AdjList(landMarkList.size());

		for (int i = 0; i < landMarkList.size(); i++) {
			for (int j = i + 1; j < landMarkList.size(); j++) {
				float diffX = landMarkList.get(i).getX()
						- landMarkList.get(j).getX();
				float diffY = landMarkList.get(i).getY()
						- landMarkList.get(j).getY();
				double distance = Math.sqrt(Math.pow(diffX, 2)
						+ Math.pow(diffY, 2));
				Edge edge = new Edge(i, j, distance);
				distanceMap.addEdge(edge);
				queue.add(edge);
			}
		}
	}

	private class DistanceComparator implements Comparator {
		@Override
		public int compare(Object obj1, Object obj2) {
			double cost1 = (double) ((Edge) obj1).getCost();
			double cost2 = (double) ((Edge) obj2).getCost();
			return (int) (cost1 - cost2);
		}
	}

	private void printResult(List<Edge> resultList) {
		double total = 0;
		for (Edge edge : resultList) {
			total += edge.getCost();
			System.out.printf("%d --> %d %.2f\n", edge.getStartVertex(), edge
					.getDestinationVertex(), edge.getCost());
		}
		System.out.printf("%.2f\n", total);
	}

	public static void main(String[] args) {
		SideWalks sideWalks = null;
		List<Edge> resultList = null;
		String mapFile = "src/lab/l09/samplePark.txt";
		sideWalks = new SideWalks(mapFile);
		resultList = KruskcalMST.kruskcalMST(sideWalks.distanceMap,
				sideWalks.queue);
		sideWalks.printResult(resultList);

		mapFile = "src/lab/l09/examplePark.txt";
		sideWalks = new SideWalks(mapFile);
		resultList = KruskcalMST.kruskcalMST(sideWalks.distanceMap,
				sideWalks.queue);
		sideWalks.printResult(resultList);

		mapFile = "src/lab/l09/examplePark2.txt";
		sideWalks = new SideWalks(mapFile);
		resultList = KruskcalMST.kruskcalMST(sideWalks.distanceMap,
				sideWalks.queue);
		sideWalks.printResult(resultList);
	}
}
