package binarySearch;

public class BinarySearch {
	static int a[] = new int[] {10,20,30,40,50,60,71,80,90,91 };
	static int search(int l, int r, int n) {
		if(l == r) {
			if (n == a[l]) {
				return l;
			}
		} else if (r -l > 0) {
			int mid = (l + r) / 2;
			if (n == a[mid]) {
				return mid;
			} else if (n < a[mid]) {
				return search(l,mid-1,n);
			} else {
				return search(mid+1,r,n);
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		System.out.println(search(0,a.length-1,17));
	}
}
