import java.util.LinkedList;
import java.util.Stack;

//RS
public class Graph {
	
	private int vertexCount;
	private boolean adjMatrix[][];
	private int edgeCount;
	private Vertex vertices[];
	
	public Graph(int n){
		this.vertexCount = n;
		this.edgeCount = 0;
		adjMatrix = new boolean[n][n];
		vertices = new Vertex[n];
		for(int i = 0; i < n; i++) {
			vertices[i] = new Vertex(i);
			//vertices[i].val = i;
			//vertices[i].visited = false;
		}
	}
	
	private boolean isValidVertex(int u){
		return ( u >= 0 && u < this.vertexCount);
	}
	
	public void addEdge(int u, int v) {
		if (isValidVertex(u) && isValidVertex(v)) {
			this.edgeCount++;
			this.adjMatrix[u][v] = true;
			this.adjMatrix[v][u] = true;
		}		
	}
	
	public void removeEdge(int u, int v) {
		if (isValidVertex(u) && isValidVertex(v)) {
			this.edgeCount--;
			this.adjMatrix[u][v] = false;
			this.adjMatrix[v][u] = false;
		}	
	}
	
	public boolean isEdge(int u, int v) {
		if (isValidVertex(u) && isValidVertex(v)) {
			return (this.adjMatrix[u][v] && this.adjMatrix[v][u]);
		}
		return false;
	}
	
	public void display() {
		for (int i = 0; i < this.vertexCount; i++) {
			System.out.println();
			for (int j = 0; j < this.vertexCount; j++) {
				if (this.adjMatrix[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}			
		}
	}
	
	public void dfs() {
		Stack<Vertex> s = new Stack();
		Vertex current;
		s.push(vertices[0]);
		while (!s.isEmpty()) {
			current = s.pop();
			if (current.visited == false) {
				System.out.println(current.val);
			}
			current.visited = true;
			for (int i = 0; i < this.vertexCount; i++) {
				//System.out.println("in for loop");
				//v = new Vertex(i);
				if (this.adjMatrix[current.val][i] == true && vertices[i].visited == false) {
					//System.out.println("in if");
					s.push(vertices[i]);
				}
			}
		}
	}
	
	void bfs() {
		LinkedList<Vertex> Q = new LinkedList();
		Vertex current;
		Q.addLast(vertices[0]);        //enqueue at the end of queue
		while ( !Q.isEmpty()) {
			current = Q.removeFirst(); //dequeue in a queue
			if (current.visited == false) {
				System.out.println(current.val);
			}
			current.visited = true;
			for (int i = 0; i < this.vertexCount; i++) {
				//System.out.println("in for loop");
				//v = new Vertex(i);
				if (this.adjMatrix[current.val][i] == true && vertices[i].visited == false) {
					//System.out.println("in if");
					Q.addLast(vertices[i]);
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		Graph G = new Graph(5);
		G.addEdge(0,1);
		G.addEdge(0,2);
		G.addEdge(0,4);
		G.addEdge(1,2);		
		G.addEdge(1,4);	
		G.addEdge(2,3);	
		G.addEdge(3,4);	
		//G.display();
		//G.dfs();
		G.bfs();
	}
}
