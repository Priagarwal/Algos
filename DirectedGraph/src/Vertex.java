
public class Vertex {
	int label;
	int indegree;
	boolean visited;
	
	
	public Vertex(int i) {
		this.label = i;
		this.visited = false;
		this.indegree = 0;
	}
	
	public void display() {
		System.out.print(" " + this.label + " ");
	}

}
