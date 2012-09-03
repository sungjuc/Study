package lec.l26;

import java.util.LinkedList;

public class AdjList {
	private class Edge {
		private int vertex;
		private int cost;

		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		public Edge(int vertex) {
			this.vertex = vertex;
			this.cost = 0;
		}

		public boolean equals(Edge otherEdge) {
			if (this.vertex == otherEdge.vertex)
				return true;
			else
				return false;
		}
	}

	private LinkedList list[];
	private int numVertices;

	public AdjList(int numVertices) {
		this.numVertices = numVertices;
		list = new LinkedList[numVertices];

		for (int index = 0; index < numVertices; index++) {
			list[index] = new LinkedList();
		}
	}

	public void addEdge(int vertexFrom, int vertexTo, int cost) {
		list[vertexFrom].add(new Edge(vertexTo, cost));
	}

	public void addEdge(int vertexFrom, int vertexTo) {
		list[vertexFrom].add(new Edge(vertexTo));
	}

	public void addBidirectedEdge(int vertexOne, int vertexTwo, int cost) {
		list[vertexOne].add(new Edge(vertexTwo, cost));
		list[vertexTwo].add(new Edge(vertexOne, cost));
	}

	public void addBidirectedEdge(int vertexOne, int vertexTwo) {
		list[vertexOne].add(new Edge(vertexTwo));
		list[vertexTwo].add(new Edge(vertexOne));
	}

	public void removeEdge(int vertexFrom, int vertexTo) {
		list[vertexFrom].remove(new Edge(vertexTo));
	}

	public void removeBidirectedEdge(int vertexOne, int vertexTwo) {
		removeEdge(vertexOne, vertexTwo);
		removeEdge(vertexTwo, vertexOne);
	}

	public int getCost(int vertexFrom, int vertexTo) {
		Edge foundEdge = find(list[vertexFrom], new Edge(vertexTo));

		if (foundEdge == null)
			return Integer.MAX_VALUE;
		else
			return foundEdge.cost;
	}

	public Edge find(LinkedList list, Edge edge) {
		for (Object item : list) {
			if (((Edge) item).equals(edge))
				return (Edge) item;
		}
		return null;
	}
}
