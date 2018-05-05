package abs;

import java.util.HashMap;
import java.util.Map;

public class TelephonePerm {
	static Map<Integer, String> map  = new HashMap<>(); 
	static String[] ar = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	static int count=0;
	public static void main(String[] args) {
		
		map.put(0, "");
		map.put(1, "");
		map.put(2, "ABC");
		map.put(3, "DEF");
		map.put(4, "GHI");
		map.put(5, "JKL");
		map.put(6, "MNO");
		map.put(7, "PQRS");
		map.put(8, "TUV");
		map.put(9, "WXYZ");
		perm("237", 0, "");
		System.out.println();
		//permArrayVersion("27", 0, "");
		System.out.println(count);
		
		
		
	}
	//Complexity - M^N so if ABC and DEF then M = len of bigger string = 3 and n = number of strings so 3^2
	// if input is ABC DEF GHI then complexit is 3^3, but if it is ABC DEF PQRS then 3^4
	static void perm(String digits, int currDigit, String prefix){
		
		//ex: we have "ABC" Digits length is 3, and currDigit is 0 for A then 1-B, 2-C when ABC is prfix it goes will "" for next combination and so currDigit =3 = digits.length 
		if(currDigit == digits.length()){
			//count++;
			System.out.println("\n->"+prefix);
			return;
		}
		
		String str = map.get(Character.getNumericValue(digits.charAt(currDigit)));
		for(int i=0; i< str.length(); i++){
			/*if(!prefix.equals(""))
				count++;*/
			System.out.print("\n..prefix "+prefix+" current dig "+currDigit);
			String p =  prefix + str.charAt(i);
			System.out.print(" .-."+p);
			perm(digits, currDigit+1, p);
		}
		
	}
	
	static void permArrayVersion(String digits, int currDigit, String prefix){
		
		//ex: we have "ABC" Digits length is 3, and currDigit is 0 for A then 1-B, 2-C when ABC is prfix it goes will "" for next combination and so currDigit =3 = digits.length 
		if(currDigit == digits.length()){
			count++;
			System.out.print(" ->"+prefix);
			return;
		}
		
		//System.out.println(".."+Character.getNumericValue(digits.charAt(currDigit))+ ar[Character.getNumericValue(digits.charAt(currDigit))]);
		//System.out.println("##"+ar[Character.getNumericValue(digits.charAt(currDigit)) + 2]);
		String str = ar[Character.getNumericValue(digits.charAt(currDigit))];
		for(int i=0; i< str.length(); i++){
			String p =  prefix + str.charAt(i);
			permArrayVersion(digits, currDigit+1, p);
		}
		
	}

	
}
