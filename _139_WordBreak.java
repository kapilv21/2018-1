package fb;

import java.util.ArrayList;
import java.util.List;
// as per my analysis complexity is 2^n
public class _139_WordBreak {
	static int count=0;
	static List<String> dict = new ArrayList<>();
	 	public static void main(String[] args) {
	 		/*dict.add("Leet");
	 		dict.add("LeetCode");
	 		dict.add("Test");	 
	 		System.out.println(wordBreak("LeetCodeTest", dict));
	 		System.out.println(" called "+count);*/
	 			
	 		//dict = ["cat", "cats", "and", "dog"].
	 		dict.add("cat");
	 		dict.add("cats");
	 		dict.add("and");
	 		dict.add("sand");
	 		dict.add("dog");
	 		System.out.println(wordBreak("catsanddog", dict));
	 		
		}
	    static boolean wordBreak(String s, List<String> wordDict) {
	        return find("", s, wordDict);
	    }
	    static  boolean find(String p, String s, List<String> dict){
	    	count++;
	        for(int i=0; i<s.length()-1;){
	        	String prefix = p+s.substring(0,i+1);
	            String ss = s.substring(i+1);
	            System.out.println(" check for " +prefix +", "+ss);
	            if(dict.contains(prefix)) {
	            	if(dict.contains(ss)) {
	            		return true;
	            	}else {
	            		if( find("", ss, dict) ==true) {
	            			return true;
	            		}else {
	            			return find(prefix, ss, dict);
	            		}
	            	}
	            }else {
	            	return find(prefix, ss, dict);
	            }
	        }
	        return false;
	    }
	}

