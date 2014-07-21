
public class PriorityQueue {
	Edge a[];
	int heapsize;
	int MAX;
	
	int parent(int i) {
		if ( i > 0 && i < heapsize) {
			return((i - 1)/2);
		}
		return -1;
	}
	
	int lchild(int i) {
		if ( i > 0 && i < heapsize) {
			int l = 2*i + 1;
			if (heapsize > l)
			return l;
		}
		return -1;
	}
	
	int rchild(int i) {
		if ( i > 0 && i < heapsize) {
			int l = 2*i + 2;
			if (heapsize > l)
			return l;
		}
		return -1;
	}
	
	boolean isEmpty() {
		return(heapsize == 0);
	}
	
	Edge deleteMin() {
		if (heapsize > 0) {
			Edge val = a[0];
			a[0] = a[heapsize-1];
			heapsize--;
			percolateDown(0);
			return val;
		}
		return null;
	}
	
	void percolateDown(int i){
		if ( i > 0 && i < heapsize) {
			int min = i;
			if ( a[lchild(i)].w < a[min].w)
				min = lchild(i);
			if ( a[rchild(i)].w < a[min].w)
				min = rchild(i);
			if (min != i) {
				Edge temp = a[i];
				a[i] = a[min];
				a[min] = temp;
				percolateDown(min);
			}
		}
	}
	
	void percolateUp(int i) {
		if ( i > 0 && i < heapsize) {
			if ( a[i].w < a[parent(i)].w) {
				Edge temp = a[i];
				a[i] = a[parent(i)];
				a[parent(i)] = temp;
				percolateUp(parent(i));
			}
		}
	}
	
	void insert(Edge e) {
		if (heapsize < MAX) {
			a[heapsize] = e;
			heapsize++;
			percolateUp(heapsize - 1);
		}
	}
	
	public PriorityQueue(int c) {
		this.MAX = c;
		a = new Edge[c];
		this.heapsize = 0;
	}

}
