package GI;

import java.util.HashMap;
import java.util.Map;

public class K_17StringWithAtMost2DistChars {
	public static void main(String[] args) {
		// "abcbbbbcccbdddadacb", the longest substring that contains 2 unique
		// character is "bcbbbbcccb".
		String s = "abcbbbbcccbdddadacb";
		findAtmostKDistinctCharsX(s, 2);
	}

	static void findAtmostKDistinctCharsX(String str, int k) {
		System.out.println("ere " + str);
		Map<Character, Integer> map = new HashMap<>();
		String s = "";
		String max = "";
		for (int i = 0; i < str.length(); i++) {
			s = s + str.charAt(i);
			addOrUpd(map, str.charAt(i));
			int t = 0;
			while (map.size() > 2 && t < s.length()) {
				// remove the first char from curr string and reduce/ remove from map
				decKey(map, s.charAt(0));
				t++;
			}
			s = s.substring(t);
			max = max.length() > s.length() ? max : s;
			System.out.println(" s at this stage " + s);
		}
		System.out.println(" FINAL rsult " + max);
	}

	static void addOrUpd(Map<Character, Integer> map, char c) {
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}

	static void decKey(Map<Character, Integer> map, char c) {
		if (map.containsKey(c)) {
			if (map.get(c) == 1) {
				map.remove(c);
			} else if (map.get(c) > 1) {
				map.put(c, map.get(c) - 1);
			}
		}
	}
}