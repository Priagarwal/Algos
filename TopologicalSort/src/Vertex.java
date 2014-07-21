import java.util.LinkedList;


public class Vertex {
	int label;
	LinkedList<Integer> adjVertices ;
	boolean visited;
	int indegree;
	
	Vertex(int val) {
		this.label = val;
		this.visited = false;
		this.adjVertices = new LinkedList<Integer>();		
		this.indegree = 0;
	}
	
	
	
}
