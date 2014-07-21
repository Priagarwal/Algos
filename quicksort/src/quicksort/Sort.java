package quicksort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sort {
	int a[];
	int N;
	int comparisons = 0;
	static String path = "C:/Users/priagarwal/Desktop/IntegerArray.txt";
	
	int getPivotFirst(int l, int r) {
		return l;
	}
	
	int getPivotFinal(int l, int r) {
		return r;
	}
	
	int getPivotMiddle(int l, int r) {
		int mid = (l + r)/2;
		int median = r;
		if ((a[mid] >= a[l] && a[mid] <= a[r]) || (a[mid] >= a[r] && a[mid] <= a[l])) {
			median = mid;
		}
		else if ((a[l] >= a[mid] && a[l] <= a[r]) || (a[l] >= a[r] && a[l] <= a[mid]))
			median = l;
		return median;
	}
	
	int getPivotMedian(int l, int r) {
		int mid = (l + r)/2;
		int median = r;
		if (a[mid] >= a[l])  {
			comparisons++;
			if ( a[mid] <= a[r]) {
				comparisons++;
				median = mid;
			} else if (a[l] >= a[r]) {
				comparisons++;
				median = l;
			} else {
				median = r;
			}
		} else {	//a[l] is greater than a[mid]
			if ( a[mid] >= a[r]) {
				comparisons++;
				median = mid;
			} else if (a[r] >= a[l]) {
				comparisons++;
				median = l;
			} else
				median = r;
		}
		return median;
	}
	
	
	void printArray() {
		System.out.println("In printArray");
		for( int k = 0; k < N; k++) {
			System.out.println(a[k]);
		}
		System.out.println();
	}
	
	void quickSort(int l, int r) {
		if (l == r) {
			return ;
		} else if (l == r -1 ) {
			if(a[l] > a[r]) {
				swap(l,r);
			}
			comparisons += 1;
		} else if(l < r - 1){
			comparisons += r-l;
			int pivotPos = partition(l,r);
			//System.out.println("Pivot is " + pivotPos);
			quickSort(l,pivotPos-1);
			quickSort(pivotPos+1,r);			
		}
		//return comparisons;
	}
	
	int partition(int l, int r) {
		int p = getPivotMedian(l, r);
		swap(p,l);
		int pivot = a[p];
		int i = l+1;
		for(int j = l+1; j <= r; j++) {
			if ( a[j] < pivot) {
				//i++;
				swap(j,i);
				i++;
			}				
		}
		swap(l,i-1);
		return (i-1);
	}
	
	void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	

	
	void read(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		ArrayList all = new ArrayList();
		int i = 0, j=0;
		while ((line = reader.readLine()) != null) {
			i = Integer.parseInt(line);
			all.add(i);			   
		}
		N = all.size();
		a = new int[N];
		for( int k = 0; k < N; k++) {
			a[k] = (int) all.get(k);
		}
			
	}
	
	public static void main(String args[]) throws IOException {
		Sort s = new Sort();
		s.read(path);
		//s.printArray();
		s.quickSort(0,s.N-1);
		System.out.println("No of comparisons are " + s.comparisons);
		//s.printArray();
		
	}
	

}
