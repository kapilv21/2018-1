package  GI.hard;
//A Java program to order of 
//characters in an alien language
import java.util.*;
public class _269_Alien_Dictionary
{	static boolean[] visited=new boolean[26];
	static private Queue<Character> postorder = new LinkedList<>();
	static List<List<Integer>> adjacent_list=new ArrayList<List<Integer>>();  

	 public static String alienOrder(String[] words){  
       if(words==null || words.length==0) return "";  
       int[] letters=new int[26];  
       for(int i=0; i<words.length; i++){  
            for(int j=0; j<words[i].length(); j++){  
                 if(letters[words[i].charAt(j)-'a']==0)  
                      letters[words[i].charAt(j)-'a']++;  
            }  
       }  
       for(int i = 0; i<letters.length; i++) {
      	 if(letters[i]>0)
      	 System.out.println((char)(i+'a')+"  "+ letters[i]);
       }
       //Create adjacent list for a directed graph  
       for(int i=0; i<26; i++)  
            adjacent_list.add(new ArrayList<Integer>());  
       //Compare each word and its next word character by character  
       //until found the first mismatching character  
       for(int i=0; i<words.length-1; i++){  
            String word1=words[i];  
            String word2=words[i+1];  
            for(int j=0; j<Math.min(word1.length(),word2.length()); j++){  
                 char c1=word1.charAt(j);  
                 char c2=word2.charAt(j);  
                 if(c1!=c2){  
                      adjacent_list.get(c1-'a').add(c2-'a');  
                      break;  
                 }  
            }  
       }  
       for (int v = 0; v < adjacent_list.size(); v++) {
           if (!visited[v] && adjacent_list.get(v).size()>0) {
        	   dfs(adjacent_list.get(v), v);
           }
       }
       // add remaining letters that were not discovered in the DFS
       for(int i=0; i<26; i++){  
           if(letters[i]>0){  
                char c = (char)(i+'a'); 
                if(!postorder.toString().contains(""+c))  
                	postorder.add(c);  
           }  
      }  
       StringBuffer sb = new StringBuffer(postorder.toString());
       return sb.reverse().toString();
  }  
	 static void dfs(List<Integer> adj, int v) {
	        visited[v] = true;
	        for (int w : adj) {
	            if (!visited[w]) {
	                dfs(adjacent_list.get(w), w);
	            }
	        }
	        postorder.offer((char)(v+'a'));
	    }

	// Driver program to test above functions
	public static void main(String[] args)
	{
		String[] words = {"wrt","wrf","erm","ett","rftv"};//{"caa", "aaa", "aab"};
		System.out.println(alienOrder(words));
	}
}

