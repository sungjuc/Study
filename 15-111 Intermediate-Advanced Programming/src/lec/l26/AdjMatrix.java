package lec.l26;

public class AdjMatrix {
	private int[][] matrix;
	private int numVertices;

	private static final int INF = Integer.MAX_VALUE;

	public AdjMatrix(int numVertices) {
		this.numVertices = numVertices;
		matrix = new int[numVertices][numVertices];

		for (int vertex = 0; vertex < numVertices; vertex++) {
			for (int otherVertex = 0; otherVertex < numVertices; otherVertex++) {
				if (otherVertex == vertex)
					matrix[vertex][otherVertex] = 0;
				else
					matrix[vertex][otherVertex] = INF;
			}
		}
	}

	public void addEdge(int vertexFrom, int vertexTo, int cost) {
		matrix[vertexFrom][vertexTo] = cost;
	}

	public void addEdge(int vertexFrom, int vertexTo) {
		addEdge(vertexFrom, vertexTo, 0);
	}

	public void addBidrectedEdge(int vertexOne, int vertexTwo, int cost) {
		addEdge(vertexOne, vertexTwo, cost);
		addEdge(vertexTwo, vertexOne, cost);
	}

	public void addBidrectedEdge(int vertexOne, int vertexTwo) {
		addEdge(vertexOne, vertexTwo, 0);
		addEdge(vertexTwo, vertexOne, 0);
	}

	public void removeEdge(int vertexFrom, int vertexTo) {
		matrix[vertexFrom][vertexTo] = 0;
	}

	public void removeBidirectedEdge(int vertexOne, int vertexTwo) {
		removeEdge(vertexOne, vertexTwo);
		removeEdge(vertexTwo, vertexOne);
	}
	
	
}
