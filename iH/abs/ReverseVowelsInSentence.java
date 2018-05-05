package abs;

import java.util.Arrays;

public class ReverseVowelsInSentence {
	public static void main(String[] args) {
		String sentence = "United States";
		System.out.println(sentence);
		reverseVowels(sentence);
	}

	static void reverseVowels(String sentence) {
		String vowels = "aeiouAEIOU";
		char[] sent = sentence.toCharArray();
		int length = sent.length-1;
		int i=0;int j=length;
		while(j>i){
			while(i<length && vowels.indexOf(sent[i]) == -1){
				i++;
			}
			while(j>=0 && vowels.indexOf(sent[j]) == -1){
				j--;
			}
			if(vowels.indexOf(sent[i]) != -1 && vowels.indexOf(sent[j]) != -1){
				char temp = sent[i];
				sent[i] = sent[j];
				sent[j] = temp;
				i++;
				j--;
			}
		}
		System.out.println(Arrays.toString(sent));
	}
}