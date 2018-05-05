package abs;

import java.util.Arrays;

public class CanTheWordMadeUsingGivenChars {
	public static void main(String[] args) {
		char[] car = new char[]{ 'a','c','e'};
		System.out.println(possibleWordsInLowerCaseChars(car, "ace"));
		
		char[] car2 = new char[]{'S','U','B', 'Z', 'a','c','e'};
		System.out.println(possibleWordsInMixCase(car2, "SUBZ"));
	}
	public static boolean possibleWordsInLowerCaseChars(char[] car, String word){
		boolean[] charArray = new boolean[127];
		for(char c : car){
			int index = c- 'a';
			charArray[index] = true;
		}
		System.out.println(Arrays.toString(charArray));
		for(char c : word.toCharArray()){
			int index = c -'a';
			if(charArray[index] == false){
				return false;
			}
		}
		return true;
	}
	
	public static boolean possibleWordsInMixCase(char[] car, String word){
		boolean[] charArray = new boolean[127];
		for(char c : car){
			int index = c;// - 'a';
			charArray[index] = true;
		}
		System.out.println(Arrays.toString(charArray));
		for(char c : word.toCharArray()){
			int index = c;///-'a';
			if(charArray[index] == false){
				return false;
			}
		}
		return true;
	}
}
