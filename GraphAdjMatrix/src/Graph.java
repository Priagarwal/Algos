import java.util.LinkedList;
import java.util.Stack;


public class Graph {
	int nVertices;
	int edgeCount;
	boolean adjMat[][];
	Vertex vertices[];
	
	public Graph(int n) {
		this.nVertices = n;
		this.adjMat = new boolean[n][n];
		this.edgeCount = 0;
		vertices = new Vertex[n];
		for (int i = 0; i < n; i++) {
			vertices[i] = new Vertex(i);
		}
	}
	
	public void addEdge(int u, int v) {
		if (u >= 0 && u < this.nVertices && v >= 0 && v < this.nVertices) {
			adjMat[u][v] = true;
			adjMat[v][u] = true;
		}
	}
	
	public void dfs() {
		System.out.println("DFS for the graph is : ");
		Stack<Vertex> s = new Stack<Vertex>(); 
		Vertex current = null;
		int next = 0;
		s.push(vertices[0]);
		while (!s.isEmpty()) {
			current = s.pop();
			current.display();
			current.visited = true;
			next = getAdjUnvisited(current.label);
			if (next != -1) {
				s.push(vertices[next]);
			}
		}
		for (int j = 0; j < this.nVertices; j++) {
			vertices[j].visited = false;
		}
		
	}
	
	public void bfs() {
		System.out.println("BFS for the graph is : ");
		LinkedList<Vertex> Q = new LinkedList<Vertex>();
		Vertex current = null;
		int next = 0;
		vertices[0].visited = true;
		Q.addLast(vertices[0]);
		while (!Q.isEmpty()) {
			current = Q.removeFirst();
			current.display();
			next = getAdjUnvisited(current.label);
			while (next != -1) {
				vertices[next].visited = true;
				Q.addLast(vertices[next]);
				next = getAdjUnvisited(current.label);
			}
		}
	}
	
	public int getAdjUnvisited(int i){
		if (i >= 0 && i < this.nVertices) {
			for (int j = 0; j < this.nVertices; j++) {
				if (adjMat[i][j]) {
					if(vertices[j].visited == false)
						return j;
				}
			}
		}
		return -1;
	}
	
	public boolean isEdge(int u, int v) {
		if (u >= 0 && u < this.nVertices && v >= 0 && v < this.nVertices) {
			return adjMat[u][v];
		}
		return false;
	}
	
	
	
	public static void main(String args[]) {
		System.out.println("Hi");
		Graph g = new Graph(6);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(1,4);
		g.addEdge(2,4);
		g.addEdge(2,3);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.dfs();
		g.bfs();
	}
}
