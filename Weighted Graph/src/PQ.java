
public class PQ {
	int a[];
	int n;
	int heapsize;
	
	public PQ(int n) {
		this.n = n;
		a = new int[n];
		this.heapsize = 0;
	}
	
	public void insert(int s) {
		if (this.heapsize < this.n) {
			a[heapsize] = s;
			this.heapsize++;
		}
	}
	
	public int delelteMin(int distance[]) {
		int min = 0, temp = 0;
		for (int i = 0; i < this.heapsize; i++) {
			if (distance[a[i]] < distance[a[min]])
				a[min] = a[i];
		}
		temp = a[min];
		for (int i = min; i < this.heapsize; i++) {
			a[i] = a[i+1];
		}
//		if (min < this.heapsize )
//			a[min] = a[this.heapsize - 1];
		this.heapsize--;
		return temp;
	}
	
	public boolean isEmpty() {
		return (this.heapsize == 0);
	}
}
