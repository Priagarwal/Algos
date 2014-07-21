package queue_array;

public class Queue {
	private int a[];
	private int MAX;
	private int front;
	private int rear;
	
	public Queue(int max) {
		a = new int[max];
		this.MAX = max;
		this.front = -1;
		this.rear = 0;
	}
	
	public boolean isEmpty() {
		if(this.front == -1 )
			return true;
		return false;
	}
	
	public boolean isFull() {
		if (this.rear == this.front )
			return true;
		return false;
	}
	
	public void enqueue(int data) {
		if (this.isFull() ) {
			System.out.println("Queue is full ");
		} 
		else {
			if (this.isEmpty()) {
				System.out.println("Empty");
				this.front = 0;
			}
			a[rear] = data;
			rear = (rear + 1) % MAX;
		}
	}
	
	public int dequeue() {
		if (this.isEmpty() ) {
			System.out.println("Underflow ");
			return 0;
		} else {
			int val = a[front];
			if ( this.front == this.rear - 1) { //indicates that the only element in queue is being deleted
				this.front = -1;
				this.rear = 0;
			} else {				
				front = (front + 1) % MAX;
			}
			return val;
		}
	}
	
	public int getFront() {
		return a[front];
	}
	
	public int getSize() {
		if(this.isFull()) {
			return MAX;
		} else if (this.isEmpty()) {
			return 0;
		} else if(front < rear){
			return (rear - front + 1);
		} else {
			return (rear + MAX - front + 1);
		}
	}
	
	public void printQueue() {
		if (this.isEmpty()) {
			System.out.print("Queue is Empty");
		} else {
			if (rear > front ) {
				for (int i = front; i < rear; i++ ) {
					System.out.print(a[i] + " ");
				}
			} else {
				for (int i = front; i < MAX; i++ ) {
					System.out.print(a[i] + " ");
				}
				for (int i = 0; i < rear; i++ ) {
					System.out.print(a[i] + " ");
				}
			}
		}
		System.out.println("");
	}
	
	public static void main(String args[]) {
		System.out.println("Hi");
		Queue Q = new Queue(5);
		Q.printQueue();
		Q.enqueue(1);
		Q.printQueue();
		Q.enqueue(2);
		Q.printQueue();
		Q.enqueue(3);
		Q.enqueue(4);
		//Q.printQueue();
		Q.enqueue(5);
		Q.printQueue();
		//Q.enqueue(6);
	}
	
}
