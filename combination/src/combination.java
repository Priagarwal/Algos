import java.util.ArrayList;
import java.util.Arrays;

public class combination {
	public static char[] getChars(int n) {
		char allChars[] = new char[n];
		//char c = n.;
		int j = 0;
		for(int i = 49; i< n+49; i++) {
			allChars[j++] = (char) (i);
		}
		return allChars;
	}
	
	public static ArrayList<String> combinations(char from[], int i, int r) {
		ArrayList<String> combos = new ArrayList<String>();
		int n = from.length-i;
		//char from[] = a;
		String s = new String();
		//from = getChars(n);
		System.out.println(n);
		//from = getInput(n);
		if(r <= 0 || i > n-r) {
			combos = null;
		} else if(r == 1) {
			for(char c : from) {
				s = c+"";
				combos.add(s);
			}			
		} else if(n == r) {
			System.out.println("In the case where n equals r");
			s = new String(from);
			System.out.println(s);
			combos.add(s);
		} else {
			ArrayList<String> combosIthTaken = combinations(from,i+1,r-1);
				for(String a : combosIthTaken) {
					a = from[i]+a;
					combos.add(a);
				}
			//if (n-i-1 >= r)	{
			ArrayList<String> combosIthNotTaken = combinations(from,i+1,r);
			if(combosIthNotTaken != null)
				combos.addAll(combosIthNotTaken);
			//}
		}
		
		//considering all are distinct
		
		return combos;
	}
	/*
	public static char[] getInput(int n) {
		char[] input = new char[n];
		input = "mango".toCharArray();
		return input;
	}
	*/
	public static void main(String args[]) {
		
		//System.out.println(getChars(5));
		System.out.println(combinations("ban".toCharArray(),0,2));
	}
}