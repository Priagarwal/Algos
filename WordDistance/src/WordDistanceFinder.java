
public class WordDistanceFinder {
	
	private String[] words;
	
	public WordDistanceFinder(String[] w) {
		words = new String[w.length];
		for (int i = 0; i < w.length; i++) {
			words[i] = new String(w[i]);
		}
	}
	
	public int distance(String a, String b) {
		int indices_a[] = new int[words.length], indices_b[] = new int[words.length], dist = -1, j= 0, k = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(a))  {
				indices_a[j++] = i;
			}
			if (words[i].equals(b)) {
				indices_b[k++] = i;
			}				
		}
		int min_dist = Math.abs(indices_a[0] - indices_b[0]);
		if (j != 0 && k != 0) {
			for (int l = 0; l < j ; l++) {
				for (int m = 0; m < k; m++) {
					dist = Math.abs(indices_a[l] - indices_b[m]);
					if (dist < min_dist) {
						min_dist = dist;
					}
				}
			}
		}
		return min_dist;
	}
	
	public void printWords(){
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}

//	public static void main(String[] args) {
//		String w[] = new String[] {"fox","the", "quick", "brown", "fox", "quick"};
//		WordDistanceFinder finder = new WordDistanceFinder(w);
//		//finder.printWords();
//		System.out.println(finder.distance("the", "fox"));
//	}

}
