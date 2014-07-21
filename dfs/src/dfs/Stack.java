package dfs;

public class Stack {
	int a[];
	int top;
	int maxSize;
	
	Stack(int n) {
		this.maxSize = n;
		this.a = new int[n];
		this.top = 0;
	}
	
	void push(int data){
		if(top >= maxSize) {
			System.out.println("Overflow");
		} else {
			a[top++] = data;
		}
	}
	
	int pop() {
		if(top == 0) {
			System.out.println("Underflow");
			return -1;
		} else {
			return(a[top--]);
		}
	}
	
	int getTop(){
		if(top == 0) {
			System.out.println("Underflow");
			return -1;
		} else {
			return(a[top]);
		}
	}

	boolean isEmpty() {
		return(top == 0);
	}
	
	boolean isFull() {
		return(top == maxSize);
	}
	
	void printStack() {
		System.out.println("Now the stack is: ");
		for(int i = top-1; i >= 0 ; i--) {
			System.out.println(a[i]);
		}
		System.out.println("------");
	}
}
