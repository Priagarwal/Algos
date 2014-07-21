import java.util.LinkedList;
import java.util.Stack;


public class Bst {
	private Node root;
	
	public Bst(Node r) {
		this.root = r;
	}
	
	public Bst() {
		this.root = null;
	}
	
	public Node insertRecursive(Node root, int d) {
		if (root == null) {
			root = new Node(d);
			return root;
		} else if ( d >= root.getData()) {
			root.setRchild(insertRecursive(root.getRchild(), d));
			return root;
		} else {
			root.setLchild(insertRecursive(root.getLchild(), d));
			return root;
		}
	}
	
	public void insertIterative(Node root, int d) {
		//System.out.println("in insertIterative");
		if (root == null) {
			root = new Node(d);
		} else {
			Node parent = root;
			while (root != null) {
				//System.out.println("Now root is " + root.getData());
				parent = root;
				if (d >= root.getData()) {
					root = root.getRchild();
					if (root == null) {
						root = new Node(d);
						parent.setRchild(root);
						return;
					}
				} else {
					root = root.getLchild();
					if (root == null) {
						root = new Node(d);
						parent.setLchild(root);
						return;
					}
				}
			}
		}
	}
	
	
	
	public boolean searchRecursive(Node root, int d) {
		if (root == null) {
			return false;
		} else if (d == root.getData()){
			return true;
		}else if ( d > root.getData()) {
			return searchRecursive(root.getRchild(), d);
		} else {
			return searchRecursive(root.getLchild(), d);
		}
	}
	
	public Node searchIterative(Node root, int d) {
		if (root == null) {
			return null;
		} else {
			while (root != null) {
				if (d == root.getData()){
					return root;
				} else if (d > root.getData()) {
					root = root.getRchild();
				} else {
					root = root.getLchild();				
				}
			}
		}
		return null;
	}
	
	public void inorderRecursive(Node root) {
		if (root == null) {
			return;
		} else {
			inorderRecursive(root.getLchild());
			System.out.print(root.getData() + " ");
			inorderRecursive(root.getRchild());
		}
	}
	
	public void inorderIterative() {
		if (this.root == null) {
			return;
		} else {
			Node current, prev;
			Stack<Node> s = new Stack<Node>();
			s.push(root);
			current = root;
			while (!s.isEmpty()) {
				//System.out.println("in while");
				prev = current;
				current = s.pop();
				if (current.getRchild() != null) {
					s.push(current.getRchild());
				}
				if (current.isChildless() || current.isInorderSuccessorOf(prev)) {
					System.out.print(current.getData() + " ");
					//prev = current;
				} else {
					s.push(current);
					if (current.getLchild() != null) {
						s.push(current.getLchild());
					}
				}	
				
			}
		}
	}
	
	public void preorderRecursive(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.getData() + " ");
			preorderRecursive(root.getLchild());			
			preorderRecursive(root.getRchild());
		}
	}
	
	public void preorderIterative(Node root) {
		if (root == null) {
			return;
		} else {
			Node current;
			Stack<Node> s = new Stack<Node>();
			s.push(root);
			while (!s.isEmpty()) {
				current = s.pop();
				System.out.print(current.getData() + " ");
				if (current.getRchild() != null) {
					s.push(current.getRchild());
				}
				if (current.getLchild() != null) {
					s.push(current.getLchild());
				}
				
			}
		}
	}
	
	public void postorderRecursive(Node root) {
		if (root == null) {
			return;
		} else {
			postorderRecursive(root.getLchild());			
			postorderRecursive(root.getRchild());
			System.out.print(root.getData() + " ");
		}
	}
	
	public void postorderIterative() {
		System.out.println();
		if (this.root == null) {
			return;
		} else {
			Node current, prev;
			Stack<Node> s = new Stack<Node>();
			s.push(root);
			current = root;
			while (!s.isEmpty()) {
				prev = current;
				current = s.pop();
				if (current.isChildless() || current.isParentOf(prev)) {
					System.out.print(current.getData() + " ");
					//prev = current;
				} else {
					s.push(current);
					if (current.getRchild() != null) {
						s.push(current.getRchild());
					}					
					if (current.getLchild() != null) {
						s.push(current.getLchild());
					}
				}				
			}
		}
	}
	
	public void levelOrderTraversal() {
		System.out.println();
		LinkedList<Node> Q = new LinkedList<Node>(); 
		Node current;
		if (this.root != null) {
			Q.addLast(this.root);
		}
		while ( !Q.isEmpty()) {
			current = Q.removeFirst();
			System.out.print(current.getData() + " ");
			if (current.getLchild() != null) {
				Q.addLast(current.getLchild());
			}
			if (current.getRchild() != null) {
				Q.addLast(current.getRchild());
			}
		}
	}
	
	public Node getInorderSuccessor(Node c) {
		if (c.getRchild() != null) {
			//return left most of right subtree
			Node root = c.getRchild();
			while (root.getLchild() != null) {
				root = root.getLchild();
			}
			return root;
		} else {
			Node current = this.root, par = null;
			while (current != c) {
				if (c.getData() < current.getData()) {
					par = current;
					current = current.getLchild();
				} else {
					current = current.getRchild();
				}				
			}
			return par;
		}
	}
	
	public DLLNode bstToDll(Node root) {
		if (root != null) {
			DLLNode n = new DLLNode(root.getData());
			DLLNode rightStart = bstToDll(root.getRchild());
			if (rightStart != null) {
				n.setNext(rightStart);
				rightStart.setPrev(n);
			} else {
				n.setNext(null);
			}
			DLLNode leftStart = bstToDll(root.getLchild());
			if (leftStart != null) {
				DLLNode current = leftStart;
				while (current.getNext() != null) {
					current = current.getNext();
				}				
				current.setNext(n);
				n.setPrev(current);
				return leftStart;
			} else {
				return n;
			}			
		}
		return null;
	}
	
	public Node DllToBst(DLLNode start) {
		if (start != null) {
			DLLNode midNode = start.getMid();
			if (midNode != null) {
				DLLNode rootNode = midNode.getNext();
				if (rootNode != null) {
					Node root = new Node(rootNode.getValue());
					DLLNode rightNode = rootNode.getNext();
					midNode.setNext(null);
					root.setRchild(DllToBst(rightNode));
					root.setLchild(DllToBst(start));
					return root;
				} else {
					Node root = new Node(midNode.getValue());
				}
			}
		}		
		return null;
	}
	
	public Node lca(int a, int b) {
		if (this.root != null) {
			Node current = this.root;
			Node parent = null;
			while (current != null) {
				if ((current.getData() > a && current.getData() < b)||(current.getData() < a && current.getData() > b)) {
					return current;
				} else if (current.getData() > a){
					parent = current;
					current = current.getLchild();
				} else if (current.getData() < a){
					parent = current;
					current = current.getRchild();
				} else if (current.getData() == a){	
					return parent;
				}
			}
		}
		return null;
	}
	
	public int delete(int d) {
		Node n = this.searchIterative(this.root,d);
		System.out.println("In delete function, the node to be deleted is " + n.getData());
		if (n != null && this.root != null) {
			int val = n.getData();
			Node current = n;
			//if childless the just delete
			if (n.getLchild() == null && n.getRchild() == null) {
				System.out.println(n.getData() + " is childless ");
				n = null;
				
			} else if (n.getLchild() != null && n.getRchild() == null) {
				System.out.println(n + " is having on leftchild ");
				//replace by n by its leftchild 
//				current = n.getLchild();
//				while (current.getRchild() != null ) {
//					current = current.getRchild();
//				}
//				n.setData(current.getData());
//				delete(current);
				n = n.getLchild();
			} else if (n.getRchild() != null && n.getLchild() == null) {
				System.out.println(n + " is having on rightchild ");
				//replace by n by its rightchild 
				//replace by leftmost of right subtree and delete rightmost
//				current = n.getRchild();
//				while (current.getLchild() != null) {
//					current = current.getLchild();
//				}
//				n.setData(current.getData());
//				delete(current);
				n = n.getRchild();
			} else  {
				System.out.println(n + " is having on both children ");
				//both children exist
				current = n.getRchild();
				while (current.getLchild() != null) {
					current = current.getLchild();
				}
				n.setData(current.getData());
				delete(current.getData());
			}			
			return val;
		}		
		return -1;
	}
	
	public int distBtwn(int a, int b) {
		if (this.root != null) {
			Node lca = this.lca(a, b);
			Node current = null;
			Node parent = null;
			int dist = 0;
			if (lca != null) {
				if (lca.getData() > a && lca.getData() > b)  {
					//means both are on left side of lca
					current = lca.getLchild();
					if (current.getData() == a) {
						while (current.getData() != b) {
							dist++;
							if ( b > current.getData()) {
								current = current.getRchild();
							} else {
								current = current.getLchild();
							}
						}
						return dist;
					}
					if (current.getData() == b) {
						while (current.getData() != a) {
							dist++;
							if ( a > current.getData()) {
								current = current.getRchild();
							} else {
								current = current.getLchild();
							}
						}
						return dist;
					}
				} else if (lca.getData() < a && lca.getData() < b) {
					//means both are on right sides of lca
					current = lca.getLchild();
					if (current.getData() == a) {
						while (current.getData() != b) {
							dist++;
							if ( b > current.getData()) {
								current = current.getRchild();
							} else {
								current = current.getLchild();
							}
						}
						return dist;
					}
					if (current.getData() == b) {
						while (current.getData() != a) {
							dist++;
							if ( a > current.getData()) {
								current = current.getRchild();
							} else {
								current = current.getLchild();
							}
						}
						return dist;
					}
					
				} else {
					//means both are on opp sides of lca
					current = lca;
					while (current.getData() != b) {
						dist++;
						if ( b > current.getData()) {
							current = current.getRchild();
						} else {
							current = current.getLchild();
						}
					}
					current = lca;
					while (current.getData() != a) {
						dist++;
						if ( a > current.getData()) {
							current = current.getRchild();
						} else {
							current = current.getLchild();
						}
					}
					return dist;					
				}
			}			
		}		
		return -1;
	}
	
	public static void main(String args[]) {
		//System.out.println("hi");
		Bst tree = new Bst(new Node(15));
		tree.insertIterative(tree.root, 10);
		//tree.inorderRecursive(tree.root);
		tree.insertIterative(tree.root, 5);
		tree.inorderIterative();
//		if (tree.searchIterative(tree.root, 25) ) {
//			System.out.println("Element exists");
//		} else {
//			System.out.println("Element doesnot exist");
//		}		
		tree.insertIterative(tree.root, 17);
		tree.insertIterative(tree.root, 12);
		tree.insertIterative(tree.root, 11);
		tree.insertIterative(tree.root, 2);
//		System.out.println();
//		tree.inorderRecursive(tree.root);
//		System.out.println();
//		tree.preorderIterative(tree.root);
//		System.out.println();
		tree.postorderIterative();
//		System.out.println();
//		tree.levelOrderTraversal();
//		System.out.println();
//		Node c = tree.root.getLchild();
//		if (c != null) {
//			System.out.println((tree.getInorderSuccessor(c)).getData());
//		}
		
		DLLNode startOfList = tree.bstToDll(tree.root);
		startOfList.printDLL();
	    System.out.println("LCA of 10 and 2 is " + tree.lca(10,2).getData());
	    System.out.println("Distance between 2 and 17 is " + tree.distBtwn(2,17));
//		Node rootNew = tree.DllToBst(startOfList);
//		Bst newTree = new Bst(rootNew);
//		newTree.inorderIterative();
	    System.out.println("root's right is " + tree.root.getRchild().getData());
		tree.delete(17);
		tree.inorderIterative();
	}
	
	
}
