package stack_array;

public class Stack {
	private int stk[];
	private int top;
	private int MAX;
	
	public Stack(int max) {
		this.MAX = max;
		stk = new int[max];
		top = -1;		
	}
	
	public int getTop() {
		return this.top;
	}
	
	public boolean isEmpty() {
		if (this.top == -1)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if (this.top == MAX-1)
			return true;
		return false;
	}
	
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			return(this.stk[top--]);
		}		
	}
	
	public void push(int n) {
		if (this.isFull()) {
			System.out.println("Stack is full");
		} else {
			this.top++;
			this.stk[this.top] = n;
		}
	}
	
	public int size() {
		return(this.top + 1);
	}
	
	public void printStk() {
		int s = this.size();
		for (int i = 0; i < s; i++ ) {
			System.out.print(this.stk[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		System.out.println("Hi");
		Stack s = new Stack(5);
		s.push(1);
		s.printStk();
		s.push(2);
		s.printStk();
		s.pop();
		s.printStk();
		s.pop();
		s.printStk();
		s.pop();
	}
	
}
