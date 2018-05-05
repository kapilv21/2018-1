package abs;

import java.util.Arrays;

public class MoveAllZerosToBeginOfArray {
	public static void main(String[] args) {
		int[] ar = new int[] { 4, 5, 6, 1, 0, 6, 8, 0, 0, 8, 9, 10 };
		System.out.println(Arrays.toString(ar));
		moveZeroesToBegin(ar);
	}
	static void moveZeroesToBegin(int[] ar){
		for(int i=ar.length-1; i>0; i--){
			if(ar[i] == 0){
				
				int j = i;
				// find next non zero
				// important to note cond for j>0 else out of bounds
				while(j>0 && ar[j] == 0){
					j--;
				}
				ar[i] = ar[j];
				ar[j] = 0;
			}
		}
		System.out.println(Arrays.toString(ar));
	}
}
