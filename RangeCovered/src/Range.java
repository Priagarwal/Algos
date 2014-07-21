import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Range {
	ArrayList<Pair> Pairs;
	
	public Range() {
		this.Pairs = new ArrayList<Pair>();
	}
	
	public Range(ArrayList<Pair> p) {
		Pairs = new ArrayList<Pair>();
		for (int i = 0; i < p.size(); i++) {
			Pairs.add(p.get(i));
		}
	}
	
	public void printPairs() {
		for (int i = 0; i < Pairs.size(); i++) {
			System.out.println("[" + Pairs.get(i).x1 + " " + Pairs.get(i).x2 + "]");
		}		
	}
	
	public void unite() {
		Collections.sort(Pairs, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				if (p1.x1 > p2.x1) {
					return 1;
				} else if (p1.x1 < p2.x1) {
					return -1;
				} else if (p1.x2 > p2.x2){
					return 1;
				} else if (p1.x1 < p2.x1) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 1; i < Pairs.size(); i++) {
			if (Pairs.get(i).x1 < Pairs.get(i - 1).x2) {
				Pair p = Pairs.get(i-1);
				p.x2 = Pairs.get(i).x2;
				Pairs.remove(i);
			}
		}
	}
	
	public int span() {
		int r = 0;
		this.unite();
		for (int i = 0; i < Pairs.size(); i++) {
			r += (Pairs.get(i).x2 - Pairs.get(i).x1);
		}
		return r;
	}
	
	public static void main(String args[]) {
		System.out.println("Hi");
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,5);
		Pair p3 = new Pair(8,9);
		Range r = new Range();
		r.Pairs.add(p1);
		r.Pairs.add(p3);
		r.Pairs.add(p2);
		r.printPairs();
		r.unite();
		System.out.println("After Uniting");
		r.printPairs();
		System.out.println("The range spanned is " + r.span());
	}
}
