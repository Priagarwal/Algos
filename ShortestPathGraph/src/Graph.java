import java.util.LinkedList;


public class Graph {
	int numVertices;
	Vertex[] vertices;
	int dist[];
	int pred[];
	
	public Graph(int n) {
		this.numVertices = n;
		dist = new int[n];
		pred = new int[n];
		vertices = new Vertex[n];
		for(int i = 0; i < n; i++) {
			vertices[i] = new Vertex(i);
			vertices[i].adjVertices = new LinkedList<Integer>();
			dist[i] = -1;
			pred[i] = -1;
		}		
	}
	
	void unweightedShortestPath(int s) {
		LinkedList<Vertex> Q = new LinkedList();
		Vertex v, w;
		Q.addLast(vertices[s]);
		dist[s] = 0;
		while (!Q.isEmpty()) {
			v = Q.removeFirst();
			for (int i = 0; i < v.adjVertices.size(); i++) {
				w = vertices[v.adjVertices.get(i)];
				if (dist[w.label] == -1) {
					 dist[w.label] = dist[v.label] + 1;
					 pred[w.label] = v.label;
					 Q.addLast(w);
				}
			}
		}
	}
	
	private void addEdge(int u, int v) {
		vertices[u].adjVertices.addFirst(v);
	}
	
	void printShortest() {
		for (int i = 0; i < this.numVertices; i++) {
			System.out.println("Shortest path for " + i + " is " + dist[i] + " and predecessor is " + pred[i]);
		}		
	}
	
	
	public static void main(String args[]) {
		//System.out.println("Hi");
		Graph G = new Graph(7);
		G.addEdge(0,1);
		G.addEdge(0,3);
		G.addEdge(1,3);
		G.addEdge(1,4);
		G.addEdge(2,0);
		G.addEdge(2,5);
		G.addEdge(3,5);
		G.addEdge(3,6);
		G.addEdge(4,6);
		G.addEdge(6,5);
		G.unweightedShortestPath(0);
		G.printShortest();
	}
}
