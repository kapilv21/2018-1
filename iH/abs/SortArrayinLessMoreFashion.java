package abs;

import java.util.Arrays;

/*
Sort an array of numbers u = [u1, u2, ... uN ] so that, for its sorted version s = [s1, s2, ..., sN] 
where: s1 <= s2 >= s3 <= s4 ... 
*
*Trick is simple to use 2 counters in orig array,
* in result put first, last, first +1, last -1 and so on
* actual idea using deque to remove one element from tail and head
* but it uses extra space and we dont need it.
*/
public class SortArrayinLessMoreFashion {
	public static void main(String args[]) {
		int[] ar = new int[] {1,2,3,5,6 }; 
		sortSpecial(ar);
	}
	
	// LeetCode solutions problem # 280. Wiggle Sort
		/*The obvious solution is to just sort the array first, 
		then swap elements pair-wise starting from the second element.
		*/public void wiggleSort(int[] nums) {
		    Arrays.sort(nums);
		    for (int i = 1; i < nums.length - 1; i += 2) {
		        swap(nums, i, i + 1);
		    }
		}

		private void swap(int[] nums, int i, int j) {
		    int temp = nums[i];
		    nums[i] = nums[j];
		    nums[j] = temp;
		}
		
	static void sortSpecial(int[] ar){
		int[] result = new int[ar.length];
		int i=0; int j=ar.length-1;
		int count=0;
		while(i<=j){
			result[count++] = ar[i];
			// check when odd elements
			if(i!=j){
				result[count++] = ar[j];
			}
			i++;j--;
		}
		System.out.println(" result "+ Arrays.toString(result));
	}
}
