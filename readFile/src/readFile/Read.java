package readFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {
	static int a[];
	
	static String path = "C:/Users/priagarwal/Desktop/IntegerArray.txt";
	
	static void read(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		ArrayList all = new ArrayList();
		int i = 0, j=0;
		while ((line = reader.readLine()) != null) {
			i = Integer.parseInt(line);
			all.add(i);			   
		}
		a = new int[all.size()];
		for( int k = 0; k < all.size(); k++) {
			a[k] = (int) all.get(k);
		}
		
		for( int k = 0; k < all.size(); k++) {
			System.out.println(a[k]);
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		read(path);
	}
}
