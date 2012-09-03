package lab.l09;

/**
 * Class represents the properties of Sets. It has a array used to represent the
 * internal tree. And the tree is used to represent the relationship between
 * sets.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 9
 * 
 */
public class UnionFind {
	private int[] list;

	/**
	 * Constructs the instance using number of vertices.
	 * 
	 * @param numVertices
	 *            the number of vertices.
	 */
	public UnionFind(int numVertices) {
		list = new int[numVertices];
		for (int i = 0; i < numVertices; i++) {
			list[i] = -1;
		}
	}

	/**
	 * Returns true if two vertices are in same set. Otherwise, false.
	 * 
	 * @param start
	 *            the index of the start vertex.
	 * @param end
	 *            the index of the end vertex.
	 * @return true if two vertices are in same set. Otherwise, false.
	 */
	public boolean find(int start, int end) {
		int startPos = start;
		int endPos = end;

		// Find the root of the tree
		while (list[startPos] != -1)
			startPos = list[startPos];

		// Find the root of the tree
		while (list[endPos] != -1)
			endPos = list[endPos];

		// If the two vertices are in same root, it is in same set.
		return endPos == startPos;
	}

	/**
	 * Unites sets contains the vertices as long as they are not in same set.
	 * Basically, this method find the root of each vertex in the set tree. If
	 * the roots are different, the two vertices are not in same set and sets
	 * can be united.
	 * 
	 * @param start
	 *            the index of start vertex.
	 * @param end
	 *            the index of end vertex.
	 */
	public void union(int start, int end) {
		// If start and end is same, return immediately since there is no reason
		// to connect same vertex.
		if (start == end)
			return;

		int startPos = start;
		int endPos = end;

		// Find the root of the tree
		while (list[startPos] != -1)
			startPos = list[startPos];

		// Find the root of the tree
		while (list[endPos] != -1)
			endPos = list[endPos];

		// Connect them if they are not in same set.
		if (endPos != startPos)
			list[endPos] = startPos;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < list.length; i++)
			result += list[i] + " ";
		return result;
	}
}
