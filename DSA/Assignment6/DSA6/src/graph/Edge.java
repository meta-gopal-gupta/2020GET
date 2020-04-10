package graph;

import java.util.Comparator;

/**
 * This class represent an edge between two vertices.
 */
public class Edge {
	private int source;
	private int destination;

	private	int weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * This comparator is used to compare two edges by their edges.
	 */
	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.getWeight()-e2.getWeight();
		}
	};

	public int compare(Edge o1, Edge o2) {
		return 0;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination
				+ ", weight=" + weight + "]";
	}




}
