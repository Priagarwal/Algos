package binaryTree;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return this.data;
	}
	public void setData(int d) {
		this.data = d;
	}
	public BinaryTreeNode getLeft() {
		return this.left;
	}
	public void setLeft(BinaryTreeNode l) {
		this.left = l;
	}
	public BinaryTreeNode getRightt() {
		return this.right;
	}
	public void setRight(BinaryTreeNode r) {
		this.right = r;
	}
}
