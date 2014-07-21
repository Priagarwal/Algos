import java.util.LinkedList;


public class Graph {
	private int vertexCount;
	private LinkedList<Integer> edgesOfVertex[];
	private int edgeCount;
	
	public Graph(int n) {
		this.vertexCount = n;
		this.edgeCount = 0;
		this.edgesOfVertex = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			this.edgesOfVertex[i] = new LinkedList<Integer>();
			edgesOfVertex[i].addFirst(i);
		}
	}
	
	public void addEdge(int u, int v) {
		this.edgeCount++;
		this.edgesOfVertex[u].addLast(v);
		this.edgesOfVertex[v].addLast(u);
	}
	
	public void removeEdge(int u, int v) {
		this.edgeCount--;
		this.edgesOfVertex[u].remove((Integer) v);
		this.edgesOfVertex[v].remove((Integer) u);
	}
	
	public void display() {
		for (int i = 0; i < this.vertexCount; i++) {
			System.out.println();
			for (int j = 0; j < this.edgesOfVertex[i].size(); j++) {
				System.out.print(this.edgesOfVertex[i].get(j));
			}
			
		}
	}
	
	public static void main(String args[]) {
		//System.out.println("Hi");
		Graph G = new Graph(4);
		//System.out.println(G.edgeCount);
		G.addEdge(0,1);
		G.addEdge(0,2);
		G.addEdge(0,3);
		G.addEdge(1,2);		
		//System.out.println(G.edgeCount);
		G.removeEdge(1,2);
		G.display();
	}
}
