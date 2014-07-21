package inversions;

public class Inversions {
	int a[];
	int sorted[];
	public Inversions(int nums[]) {
		this.a = new int[nums.length];
		a = nums;
		this.sorted = new int[nums.length];
	}
	
	
	void countInversions(int b[], int c[]) {
		int i = 0, j = 0;
		for(int k = 0; k < a.length; k++) {
			if ((i < b.length) && ((b[i] < c[j]) || (j == c.length)) ) {
				a[k++] = b[i++];
			} else if ( j < c.length || (i == b.length)) {
				a[k++] = c[j++];
			}			
		}
		
	}
	
	void printArray() {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int a[] = new int[]{71, 23, 9};//, 78, 9, 62, 5, 10, 34};
		System.out.println(a.length);
		Inversions m = new Inversions(a);
		m.sort(0,a.length-1);
		m.printArray();
	}
	
}
