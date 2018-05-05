package abs;

import java.util.Arrays;

public class ArrayLeftSumRightSumEqual {
	public static void main(String[] args) {
		int[] ar = new int[] { 1, 4, 2, 5 };
		//int[] ar = new int[] { 1, 4, 2, 5 };
		System.out.println(getIndexByPrefixAndSuffixArray(ar));
		System.out.println(getIndex(ar));
		System.out.println(getIndexByPrefixArray(ar));
	}
	/*COMPLEXITY 0(2N) SPACE - 0(1)
	 * array  [1, 4, 2, 5]
	 * calculate total sum as 12
	 * store total sum in rightsum
	 * iter over array from 0-l
	 * right sum = rightsum-curr; // because rs has total sum at start
	 * ls will be updated at end of loop 
	 * loop 1 :
	 * ls = 0(initially) 
	 * rs = 12-1 = 11 
	 * update ls = 1 now for next step
	 * 
	 * loop 2:
	 * ls = 1 from above step
	 * rs = 11-4 = 7
	 * 1!=7 so not ans
	 * ls updated to 1+4 = 5
	 * 
	 * loop 3:
	 * ls = 5
	 * rs = 7-2 = 5
	 * 5==5 is ans
	 */
	static int getIndex(int[] ar) {
		int totalSum = 0;
		int index = 0;
		for (int i = 0; i < ar.length; i++) {
			totalSum += ar[i];
		}
		System.out.println(" total "+totalSum);
		// ls will be 0 for first element
		int leftSum = 0;
		int rightSum = totalSum;
		for (int i = 0;i < ar.length; i++) {
			rightSum = rightSum - ar[i];
			if (leftSum == rightSum) {
				index = i; // or can say j
			}
			//update ls for next step
			leftSum += ar[i];
		}
		return index;
	}
	
	/* COMPLEXITY 0(N) SPACE - 0(N)
	 * only 1 array
	 prefix array is left sum including self
	 * array  [1, 4, 2, 5]
	 * prefix [1, 5, 7, 12] 
	 * suffix [12, 11, 7, 5] we are not using suffix array as we will just do with rs
	 * */
	private static int getIndexByPrefixArray(int[] ar) {
		System.out.println(" array len " + ar.length);
		int[] prefix = new int[ar.length];
		int sumSoFar = 0;
		for (int i = 0; i < ar.length; i++) {
			sumSoFar += ar[i];
			prefix[i] = sumSoFar;
		}
		
		System.out.println(" prefix "+Arrays.toString(prefix));
		int rsIncludingSelf = 0;
		for(int i=ar.length-1;i>=0; i--) {
			rsIncludingSelf = rsIncludingSelf+ar[i];
			if( rsIncludingSelf== prefix[i]) {
				return i;
			}
		}
		
		return -1;

	}
	
	/* COMPLEXITY 0(N) SPACE - 0(2N)
	 * Go in loop 1 left to end and calculate left sum stored prefix array
	 * Go in loop 2 right to first and calculate right sum stored suffix array
	 * Loop though 1..ar.len-1, check if prefix[i] == suffix[i], this is the answer
	 * array  [1, 4, 2, 5]
	 * prefix [1, 5, 7, 12] 
	 * suffix [12, 11, 7, 5]
	 */
	private static int getIndexByPrefixAndSuffixArray(int[] ar) {
		System.out.println(" array len " + ar.length);
		int[] prefix = new int[ar.length];
		int[] suffix = new int[ar.length];
		int sumSoFar = 0;
		for (int i = 0; i < ar.length; i++) {
			sumSoFar += ar[i];
			prefix[i] = sumSoFar;
		}
		sumSoFar = 0; // reset sum so far
		for (int i = (ar.length - 1); i >= 0; i--) {
			sumSoFar += ar[i];
			suffix[i] = sumSoFar;
		}
		System.out.println(Arrays.toString(ar));
		System.out.println(" prefix " + Arrays.toString(prefix));
		System.out.println(" suffix " + Arrays.toString(suffix));

		for (int i = 0; i < ar.length - 1; i++) {
			if (prefix[i] == suffix[i]) {
				return i;
			}
		}
		return -1;

	}
}
