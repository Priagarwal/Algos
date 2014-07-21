
public class Node{
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void setData(int d) {
		this.data = d;
	}
	
	public int getData() {
		return(this.data);
	}
	
	public void setNext(Node n) {
		this.next = n;
	}
	
	public Node getNext() {
		return(this.next);
	}
	
}