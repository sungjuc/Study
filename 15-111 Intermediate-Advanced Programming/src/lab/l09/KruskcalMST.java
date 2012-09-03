package lab.l09;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class contains the Kruskcal's algorithm. This class provide the krusckal
 * algorithm in shape of static method.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 9
 * 
 */
public class KruskcalMST {
	/**
	 * Creates the minimum spanning tree with Kruscal's algorithms. The input
	 * value is Adjacent list and sorted Edge list.
	 * 
	 * @param list
	 *            the adjacent list.
	 * @param queue
	 *            the priority queue of edges.
	 * @return the list of minimum spanning tree.
	 */
	public static List<Edge> kruskcalMST(AdjList list, PriorityQueue<Edge> queue) {
		List<Edge> result = new ArrayList<Edge>();
		UnionFind unionFind = new UnionFind(list.getNumVertices());

		Edge edge = null;

		// Iterate the queue.
		while (queue.peek() != null) {
			edge = queue.poll();

			int start = edge.getStartVertex();
			int end = edge.getDestinationVertex();

			// If the edge doesn't create circle, connect them
			if (!unionFind.find(start, end)) {
				unionFind.union(start, end);
				result.add(edge);
			}
		}

		return result;
	}
}
