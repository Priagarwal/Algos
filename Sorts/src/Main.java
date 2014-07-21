//RS

public class Main {
	static int a[];
	
	static void swap(int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void bubbleSort() {
		int n= a.length;
		for(int i = 0; i < n - 1; i++) {
			for ( int j = i + 1; j < n ; j++) {
				if (a[i] > a[j]) {
					swap(i,j);
				}
			}
		}
	}
	
	static void selectionSort() {
		int n= a.length;
		for(int i = 0; i < n - 1; i++) {
			for ( int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	
	static void insertionSort() {
		int n= a.length;
		int temp = 0;
		int j = 0;
		for(int i = 1; i < n; i++) {
			temp = a[i];	
			j = i-1;
			while(j >=0 && a[j] > temp ) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;						
		}
	}
	
	
	
	static void printArray() {
		int n= a.length;
		System.out.println();
		for(int i = 0; i < n; i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String args[]) {
		System.out.println("Hi");
		a = new int[] {9,7,3,14,8};
		printArray();
		//bubbleSort();
		//selectionSort();
		insertionSort();
		printArray();
	}
}
