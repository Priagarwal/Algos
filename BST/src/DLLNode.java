
public class DLLNode {
	int val;
	DLLNode next;
	DLLNode prev;
	
	public DLLNode(int v) {
		this.val = v;
		this.next = null;
		this.prev = null;
	}
	
	public void setNext(DLLNode n) {
		this.next = n;
	}
	
	public void setPrev(DLLNode n) {
		this.prev = n;
	}
	
	public DLLNode getNext() {
		return this.next;
	}
	
	public DLLNode getPrev() {
		return this.prev;
	}
	
	public void setValue(int v) {
		this.val = v;
	}
	
	public int getValue() {
		return this.val;
	}
	
	public DLLNode getMid() {
		DLLNode start = this;
		if (start != null) {
			DLLNode slow = start, fast = start;
			while (fast != null) {
				fast = fast.getNext();
				if (fast != null) {
					slow = slow.getNext();
					fast = fast.getNext();
				}
			}
			return slow.getPrev();
		}
		return null;
	}
	
	public void printDLL() {
		System.out.println("The doubly ll formed is :");
		DLLNode current = this;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.getNext();
		}
	}
}
