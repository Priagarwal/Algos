import java.util.LinkedList;


public class Graph {
	int numVertices;
	Vertex[] vertices;
	//int indegree[];
	int order[];
		
	public Graph(int n) {
		this.numVertices = n;
		//indegree = new int[n];
		vertices = new Vertex[n];
		order = new int[n];
		for(int i = 0; i < n; i++) {
			vertices[i] = new Vertex(i);
			vertices[i].adjVertices = new LinkedList<Integer>();
			//indegree[i] = -1;
		}		
	}
	
	void topologicalSort() {
		LinkedList<Vertex> Q = new LinkedList();
		int counter = 0;
		Vertex v, w;
		for (int i = 0; i < this.numVertices; i++) {
			if(vertices[i].indegree == 0) {
				Q.addLast(vertices[i]);
			}
		}
		while (!Q.isEmpty()) {
			v = Q.removeFirst();
			order[counter++] = v.label;
			for (int i = 0; i < v.adjVertices.size(); i++) {
				w = vertices[v.adjVertices.get(i)];
				w.indegree--;
				if (w.indegree == 0) {
					Q.addLast(w);
				}
			}
		}
		
		if (counter != this.numVertices) {
			System.out.println("G has a cycle");
		}
	}
	
	private void addEdge(int u, int v) {
		vertices[u].adjVertices.addFirst(v);
		vertices[v].indegree++;
	}
	
	void printOrder() {
		for (int i = 0; i < this.numVertices; i++) {
			System.out.print(order[i] + " ");
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
		G.topologicalSort();
		G.printOrder();
	}
}
