package abs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Find all words that have same unique char set 
 * First create unique char map, for that you parse the char in word and store in 26 char array(boolean)
 * then go from index 1 to last of char array and form a key, this way we have key in 
 * sorted order like abcd, for ex : for may and yam the gen index is amy 
 * this way we collect all similar words in the list, so map has entry like <amy, List<index> of may and yam
 * then parse map to get the similar words; 
*/
public class Words_With_Unique_Chars {
	public static void main(String[] args) {
		 String words[] = { "may", "student", "students", "dog",
                 "studentssess", "god", "cat", "act", "tab",
                 "bat", "flow", "wolf", "lambs", "amy", "yam",
                 "balms", "looped", "poodle"};
    int n = words.length;
    Map<String, List<Integer>> map = wordsWithSameCharSet(words, n);
    printMap(map, words);
	}
	
	static Map<String, List<Integer>> wordsWithSameCharSet(String[] words, int len){
		System.out.println("all keys "+getKey("may"));
		Map<String, List<Integer>> map = new HashMap<>();
		List<Integer> indexList;
		for(int i = 0; i<words.length; i++){
			String word = words[i];
			String key = getKey(word);
			if(map.containsKey(key)){
				indexList = map.get(key);
			}else{
				indexList = new ArrayList<>();
			}
			indexList.add(i);
			map.put(key, indexList);
		}
		return map;
	}
	static void printMap(Map<String, List<Integer>> map, String[] words){
		for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
			System.out.print(" \n "+entry.getKey()+" => ");
			for(int i : entry.getValue()){
				System.out.print(" ,"+words[i]);
			}
		}
	}
	static String getKey(String str){
		boolean[] car = new boolean[26];
		for(char c : str.toCharArray()){
			int i = c - 'a';
			car[i] = true;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<car.length;i++){
			if(car[i] == true){
				char c = (char)(i+'a');
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
