package abs;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class OneCharSubstitute {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("apple");
		set.add("pear");
		System.out.println(isValidWord(set, "adple"));
		System.out.println(isValidWord(set, "addle"));
		System.out.println(isValidWord(set, "aple"));

	}

	static boolean isValidWord(Set<String> dictionary, String word) {
		for (int i = 0; i < word.length(); i++) {
			// make sure the char array is made here else we get stale data
			// if we put above the main foor loop then the carray is Zpple
			// then in second iter the array retains the last elem again zzple
			char[] cArray = word.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				cArray[i] = c;
				if (dictionary.contains(new String(cArray))) {
					return true;
				}
			}
		}
		return false;
	}
	
	///////////////////////////////////////////
	// OLD Version
	
public static boolean isValidWord2(Set<String> dictionary, String word) {
		
		if(word == null || word.length()<1){
			return false;
		}
		
		for (String s : replaceOneCharAtATime(word)) {
			if (dictionary.contains(s.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private static Set<String> replaceOneCharAtATime(String word) {
		Set<String> words = new TreeSet<String>();
		for (int i = 0; i < word.length(); i++) {
			char[] charArr = word.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != word.charAt(i)) {
					charArr[i] = c;
					words.add(new String(charArr));
				}
			}
		}
		return words;
	}

}
