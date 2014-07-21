public class Mergesort {
	static int a[];
	static int sorted[];
	
	
	static int[] mergesort(int l, int r){
		if ( l < r) {
			int mid = (l + r)/2;
			int b[] = mergesort(l, mid);
			int c[] = mergesort(mid + 1, r);
			return(merge(b,c));
		} else {
			sorted = new int[1];
			sorted[0] = a[l];
			return sorted;	
		}
			
	}
	
	static int[] merge(int b[], int c[]) {
		int blen = b.length, clen = c.length ;
		int n = blen + clen;
		int d[] = new int[n];
		int i = 0, j = 0, k = 0;
		for(k = 0; k < n && i < blen && j < clen; k++) {
			if (i < blen && b[i] <= c[j]) {
				d[k] = b[i++];
			} else {
				d[k] = c[j++];
			}
		}
		if ( k < n) {
			if ( i < blen) {
				while (k < n) {
					d[k++] = b[i++];
				}
			} else if (j < clen) {
				while (k < n) {
					d[k++] = c[i++];
				}
			}
		}
		return d;
	}
	
	static void printArray() {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		a = new int[]{71, 23, 9};//, 78, 9, 62, 5, 10, 34};
		printArray();
		a = mergesort(0, a.length - 1);
		printArray();
	}
}