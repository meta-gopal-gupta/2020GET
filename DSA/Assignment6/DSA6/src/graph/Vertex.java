package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private int vertexName;
	private List<Edge> adjancyEdges = new ArrayList<Edge>();


	public Vertex(int vertex) {
		this.vertexName = vertex;
	}


	public void addEdge(Edge edge) {
		adjancyEdges.add(edge);
	}


	public int getVertexName() {
		return vertexName;
	}


	public List<Edge> getAdjancyEdges() {
		return adjancyEdges;
	}



}
