
public class Vertex {
	int label;
	boolean visited;
	
	
	public Vertex(int i) {
		this.label = i;
		this.visited = false;
	}
	
	public void display() {
		System.out.print(" " + this.label + " ");
	}

}
