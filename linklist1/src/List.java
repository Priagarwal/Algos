public class List {
	private Node start;
	private int length;
	
	public List(Node s) {
		this.start = s;
		if(s != null) {
			this.length = 1;
		} else {
			this.length = 0;
		}
	}
	
	public List(int d) {
		this(new Node(d));
	}
	
	public Node getStart() {
		return(this.start);
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void insertAtBeg(int d) {
		Node n = new Node(d);
		if(this.start != null) {
			n.setNext(this.start);
		}
		this.start = n;
		this.length++;
	}
	
	public int deleteFromBeg() {
		int val = 0;
		Node n;
		if(this.start != null) {
			n = this.getStart();
			val = n.getData();
			this.start = n.getNext();
			this.length--;
		}
		return val;
	}
	
	public int deleteAtPos(int p) {
		if(this.length < p) {
			return 0;
		}else if(p == 1){
			int val = start.getData();
			this.start = null;
			this.length--;
			return val;
		}else {
			int i = 1;
			Node n = this.start;
			while (i < (p-1)) {
				n = n.getNext();
				i++;
			}
			Node toBeDel = n.getNext();
			n.setNext(toBeDel.getNext());
			this.length--;
			return toBeDel.getData();
		}
	}
	
	public int delAtEnd() {
		return(this.deleteAtPos(length));
	}
	
	public void insertAtPos(int pos, int data) {
		Node b = new Node(data);
		if((this.length + 1) < pos) {
			System.out.println("List is shorter");
		} else if(pos == 1) {
			this.insertAtBeg(data);
		} else {
			int i = 1;
			Node a = this.start;
			while (i < (pos-1)) {
				a = a.getNext();
				i++;
			}
			Node c = a.getNext();
			a.setNext(b);
			b.setNext(c);
			this.length++;
		}
		
	}
	
	public void insertAtEnd(int d) {
		this.insertAtPos(length+1,d);
	}
	
	public void printList() {
		int val = 0;
		Node n;
		if(this.start != null) {
			n = this.getStart();
			while (n != null) {
				val = n.getData();
				System.out.print(val + "  ");
				n = n.getNext();
			}
			System.out.println();
		}
	}
	
	public void reverseListIterative() {
		Node root = this.start;
		if (root != null) {
			Node a, b, c;
			a = root;
			
			b = a.getNext();
			if ( b != null) {
				a.setNext(null);
				c = b.getNext();
				while ( c != null) {
					b.setNext(a);
					a = b;
					b = c;
					c = c.getNext();
				}
				b.setNext(a);
				root = b;
				this.start = b;
			}
		}
	}
	
	public Node reverseListRecursive(Node root) {
		if (root != null) {
			Node a = root;
			Node b = root.getNext();
			if ( b != null) {
				a.setNext(null);
				Node reversed = reverseListRecursive(b);
				b.setNext(a);
				return(reversed);
			}
			return a;
		}
		return null;	
	}
	
	
	
	public static void main(String args[]) {
		List l = new List(2);
		//l.printList();
		l.insertAtBeg(1);
		//l.printList();
		l.insertAtPos(2, 3);
		//l.printList();
		l.delAtEnd();
		//l.printList();
		l.insertAtEnd(4);
		//l.printList();
		l.deleteFromBeg();
		l.insertAtBeg(1);
		l.insertAtPos(2, 2);
		l.printList();
		//l.reverseListIterative();
		l.start = l.reverseListRecursive(l.start);
		l.printList();
	}
}