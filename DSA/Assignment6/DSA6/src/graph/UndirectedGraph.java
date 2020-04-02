package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is implementation by undirected graph.
 */
public class UndirectedGraph implements Graph {

	private int numberOfVertices;
	private Vertex vertices[];
	LinkedList<Edge> edgeList = new LinkedList<Edge>();

	/**
	 * This constructor is used to initialize undirected graph.
	 * @param numberOfVertices represent number of vertices.
	 */
	public UndirectedGraph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();

		for(int i = 0; i < numberOfVertices; i++) {
			vertices[i] = new Vertex(i);
		}
	}

	/**
	 * This method is used to add an edge between two vertices.
	 * @param source represents source of edge.
	 * @param destination represents destination of edge.
	 * @param weight represents weight/distance of edge.
	 */
	public void addEdge(int source, int destination, int weight) {
		if(source >= 0 && source < numberOfVertices && destination >= 0 && destination < numberOfVertices) {
			Edge edge = new Edge(source,destination,weight);
			Edge reverseEdge = new Edge(destination, source, weight);
			vertices[source].addEdge(edge);
			vertices[destination].addEdge(reverseEdge);
			edgeList.add(edge);
		}
	}

	/**
	 * This method is used to display graph.
	 */
	public void displayGraph() {	
		for (int v = 0; v < numberOfVertices; ++v) 
		{ 
			System.out.println("Adjacncy list of vertex : " + v );

			for (Edge edge : vertices[v].getAdjancyEdges()) 

				System.out.println(edge.toString());

		} 
	} 


	/**
	 * This method creates an adjancy matrixfor graph.
	 * @return adjancy matrix.
	 */
	private int[][] createAdjancyMatrix() {
		int graph[][] = new int[numberOfVertices][numberOfVertices];
		for(Edge edge : edgeList) {
			graph[edge.getSource()][edge.getDestination()] = edge.getWeight();
			graph[edge.getDestination()][edge.getSource()] = edge.getWeight();

		}

		return graph;
	}

	/**
	 * This method is used to check whether graph is connected or not
	 * @return true or false accordingly.
	 */
	public boolean isConnected() {
		boolean visited[] = new boolean[numberOfVertices];
		visited = dfs(0, visited);
		for(boolean visit : visited) {
			if(!visit) {
				return false;
			}
		}
		return true;

	}


	/**
	 * This method is used to perform depth first search.
	 * @param currentVertex is current visited vertex.  
	 * @param visited is an array that have vertex those are visited.
	 * @return visited boolean array.
	 */
	private boolean[] dfs(int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;

		for(Edge edge : vertices[currentVertex].getAdjancyEdges()) {

			if(!visited[edge.getDestination()]) {
				dfs(edge.getDestination(), visited);
			}		
		}

		return visited;
	}

	/**
	 * This method is used to find all reachable node from given vertex.
	 * @param vertex is an graph vertex.
	 * @return list of reachable vertices.
	 */
	public List<Integer> reachable(int vertex) { 
		List<Integer> rechableNodes = new ArrayList<Integer>();
		boolean visited[] = new boolean[numberOfVertices];
		visited = dfs(vertex, visited);
		for(int i = 0; i < numberOfVertices; i++ ) {
			if(visited[i]) {
				rechableNodes.add(i);
			}
		}
		return rechableNodes;
	}

	/**
	 * This method is used to find minimum spanning tree of graph.
	 * @return list of edges in minimum spanning tree.
	 */
	public List<Edge> minimumSpanningTree() {
		List<Edge> minimumSpanningTreeEdges = new ArrayList<Edge>();
		Collections.sort(this.edgeList, Edge.sortByWeight);
		int parentVertices[] = new int[numberOfVertices];

		for(int i = 0; i < this.numberOfVertices; i++) {
			parentVertices[i] = i;
		}

		for(Edge edge : this.edgeList) {
			if(!isCycle(parentVertices,edge.getSource(),edge.getDestination())) {
				minimumSpanningTreeEdges.add(edge);	
			}
		}
		return minimumSpanningTreeEdges;
	}

	
	/***
	 * This method checks if Cycle exists in graph
	 * @param parentVertices
	 * @param source
	 * @param destination
	 * @return
	 */
	private boolean isCycle(int[] parentVertices,int source,int destination) {
		int sourceParent = findParent(parentVertices,source);
		int destinationParent = findParent(parentVertices,destination);
		if(sourceParent == destinationParent) {
			return true;
		}

		parentVertices[sourceParent] = destinationParent;
		return false;
	}

	/***
	 * This method finds parent of given vertex
	 * @param parentVertices
	 * @param vertex
	 * @return
	 */
	private int findParent(int[] parentVertices,int vertex) {
		if(parentVertices[vertex] == vertex) {
			return vertex;
		}
		return findParent(parentVertices, parentVertices[vertex]);
	}

	/***
	 * This method is used to find shortest path from given source to destination
	 */
	public int shortestPath(int source, int destination) {

		int graph[][] = createAdjancyMatrix();
		int dest[] = dijkstra(graph, source);

		return dest[destination];

	}

	/***
	 * This method is used to perform dijkstra algorithm.
	 * @param graph
	 * @param source
	 * @return
	 */
	private int[] dijkstra(int graph[][], int source) { 
		int distance[] = new int[numberOfVertices];
		Boolean shortestPathVertices[] = new Boolean[numberOfVertices]; 
		for (int i = 0; i < numberOfVertices; i++) { 
			distance[i] = Integer.MAX_VALUE;
			shortestPathVertices[i] = false;
		} 
		distance[source] = 0; 
		for (int count = 0; count < numberOfVertices - 1; count++) { 

			int u = minDistance(distance, shortestPathVertices); 
			shortestPathVertices[u] = true; 
			for (int v = 0; v < numberOfVertices; v++) 
				if (!shortestPathVertices[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) 
					distance[v] = distance[u] + graph[u][v]; 
		} 

		return distance; 
	} 


	/**
	 * This method is used find vertex with minimum distance.
	 * @param 
	 * @param 
	 * @return 
	 */
	private int minDistance(int distance[], Boolean shortestPathVertices[]) 
	{ 
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < numberOfVertices; v++) 
			if (shortestPathVertices[v] == false && distance[v] <= min) { 
				min = distance[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 
}
