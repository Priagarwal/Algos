import java.util.HashMap;

public class Main {
	public static HashMap<Character, Integer> counters;
	public static char s[][];
	private static int shortest = 0;
	
	public static void constructMap() {
		int minlength = s[0].length;
		
		Character c;
		Integer val;
		for (int i = 1; i < s.length; i++ ){
			if ( s[i].length < minlength) {
				minlength = s[i].length;
				shortest = i;
			}
		}
		counters = new HashMap<Character, Integer>(minlength);  //construct the hashmap with all characters of smallest string 
		char[] smallest = s[shortest];
		for (int i = 0; i < minlength; i++) {
			counters.put(smallest[i], 1); // for each character counting 1 for smallest itself
		}
		//scan through all the remaining strings and check for each character of smallest and increment the counter if present
		for (int i = 1; i < s.length; i++ ){
			for (int j = 0; j < s[i].length; j++) {
				c = s[i][j];				
				if (counters.containsKey(c)) {
					val = counters.get(c);
					counters.put(c,val + 1 );
				}
			}
		}		
	}
	
	public static void allCommons() {
		Character c;
		for (int i = 0; i < s[shortest].length; i++) {
			c = s[shortest][i];
			if (counters.get(c) == s.length) {
				System.out.println(c);
			}
		}		
	}
	
	public static void buildUniqueChars(char strings[][]) {
		int count = 0;
		for (char[] x:strings) {
			s[count] = uniqueChars(x);
			count++;
		}
	}
	
	public static char[] uniqueChars(char[] str) {
		char[] uniq = new char[str.length];
		boolean all[] = new boolean[26];
		char c;
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			c = str[i];
			if (all[c-'a'] == false) {
				all[c-'a'] = true;
				uniq[count++] = c;
			}
		}
		uniq[count] = '\0';
		return uniq;
	}
	
	public static void main(String args[]) {
		System.out.println("Hi");
//		s = new String[4];
//		s[1] = new String("helo");
//	    s[2] = new String("hel");
//	    s[3] = new String("yelw");
//	    s[0] = new String("help");
//		constructMap();
//		allCommons();
		System.out.println(uniqueChars("hellpip".toCharArray()));
	}
	
}