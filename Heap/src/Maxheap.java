
public class Maxheap {
	int a[];
	int capacity;
	int heapsize;
	
	public Maxheap(int size) {
		this.capacity = size;
		this.a = new int[size];
		this.heapsize = 0;
	}
	
	public int parent(int i) {
		if ( i > 0 && i < this.heapsize) {
			return (i - 1) / 2;
		}
		return -1;
	}
	
	public int lChild(int i){
		if ( i >= 0 && i < this.heapsize) {
			int lchild = (2 * i ) + 1;
			if (lchild < this.heapsize) {
				return lchild;
			}
		}		
		return -1;
	}
	
	public int rChild(int i){
		if ( i >= 0 && i < this.heapsize) {
			int rchild = (2 * i ) + 2;
			if (rchild < this.heapsize) {
				return rchild;
			}
		}		
		return -1;
	}
	
	public void percolateDown(int i) {
		System.out.println("In percolate Down");
		if ( i >= 0 && i < this.heapsize/2) {
			int max = i;
			int l = this.lChild(i);
			int r = this.rChild(i);
			if ( l != -1)
				System.out.println("Left child for " + a[i] + " is " + a[l]);
			if ( r != -1)
				System.out.println("Right child for " + a[i] + " is " + a[r]);
			if (l != -1 && this.a[l] > this.a[max]) {
				max = l;
			}
			if (r != -1 && this.a[r] > this.a[max]) {
				max = r;
			}
			if (max != i) {
				System.out.println("Now max is " + a[max]);
				int temp = a[i];
				this.a[i] = a[max];
				a[max] = temp;
				percolateDown(max);
			}
			
		}
	}
	
	public int percolateUp(int i) {
		if ( i > 0 && i < this.heapsize) {
			int par = this.parent(i);
			int temp = 0;
			while (par != -1 && a[par] < a[i]) {
				temp = a[i];
				this.a[i] = a[par];
				a[par] = temp;
				i = par;
				par = this.parent(par);
			}
			return i;
		}
		return -1;
	}
	
	public int getMax() {
		if (this.heapsize != 0) {
			return this.a[0];
		}
		return -1;
	}
	
	public int getMin(){
		if (this.heapsize != 0) {
			int leaf = this.heapsize / 2;
			int min = this.a[leaf];
			leaf++;
			while (leaf < this.heapsize) {
				if (a[leaf] < min) {
					min = a[leaf];
				}
				leaf++;
			}
			return min;
		}
		return -1;
	}
	
	public int deleteMax(){
		if (this.heapsize != 0) {
			int max = a[0];
			this.a[0] = this.a[this.heapsize - 1];
			this.heapsize--;
			System.out.println("Heapsize is " + this.heapsize);
			this.percolateDown(0);
			return max;
		}
		return -1;
	}
	
	public int insert(int i) {
		if (this.heapsize != this.capacity) {
			a[this.heapsize] = i;
			this.heapsize++;
			return this.percolateUp(this.heapsize - 1);
		} else {
			return -1;
		}		
	}
	
	public void buildHeap(int d[]) {
		if (this.capacity >= d.length) {
			this.heapsize = 0;			
			for (int i = 0; i < d.length; i++) {
				this.insert(d[i]);
			}
		}	
	}
	
	public static Maxheap makeHeap(int d[]) {
		Maxheap h = new Maxheap(d.length * 2);
		for (int i = 0; i < d.length; i++) {
			h.insert(d[i]);
		}
		return h;
	}
	
	public void printHeap() {
		if (this.heapsize != 0) {
			System.out.println("The heap is: ");
			for (int i = 0; i <this.heapsize; i++) {
				System.out.print(this.a[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void heapsort(int d[]) {
		Maxheap h = makeHeap(d);
		int n = 0;
		for (int i = 0; i < d.length; i++) {
			n = h.deleteMax();
			d[i] = n;
		}
		System.out.println("The sorted array is ");
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Hi");
		int arr[] = new int[]{1,7,3,8,9};
		Maxheap h = makeHeap(arr);
		h.printHeap();
		h.insert(4);
		h.printHeap();
		System.out.println(h.getMin());
		System.out.println(h.getMax());
		System.out.println(h.deleteMax());
		h.printHeap();
		heapsort(arr);
	}	
	
}
