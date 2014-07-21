
public class ListNode {
	int label;
	ListNode next;
	
	public ListNode() {
	}
	
	public void addFirst(int i) {
		ListNode n = new ListNode();
		n.label = this.label;
		n.next = this.next;
		this.label = i;
		this.next = n;
	}
	
	public boolean contains(int v) {
		ListNode n = this;
		while (n != null) {
			if (n.label == v)
				return true;
			n = n.next;
		}
		return false;
	}
}
