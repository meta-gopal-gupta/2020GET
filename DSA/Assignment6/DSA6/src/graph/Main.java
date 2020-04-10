package graph;

import java.util.List;

public class Main {

	public static void main(String args[]) {

		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge(0, 1,5); 
		graph.addEdge(0, 4,6); 
		graph.addEdge(1, 2,7); 
		graph.addEdge(1, 3, 8); 
		graph.addEdge(1, 4, 9); 
		graph.addEdge(2, 3, 20); 
		graph.addEdge(3, 4, 2);
		graph.displayGraph();
		System.out.println(graph.isConnected());
		System.out.println("Rechable Nodes: ");
		for(int node : graph.reachable(4)) {
			System.out.println(node);
		}
		System.out.println("Minimum spanning tree: ");
		List<Edge>  minSpanningTree = graph.minimumSpanningTree();
		for(Edge edge : minSpanningTree) {
			System.out.println(edge.toString());
		}
		System.out.println("shortest path: " +graph.shortestPath(0,4));

	}
}
