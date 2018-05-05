package abs;

import java.util.Arrays;

public class ThreeColorFlag {
	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 0, 2, 2, 1, 0, 1, 0, 0, 1 };
		sortColors(nums);
		System.out.println(".>>." + Arrays.toString(nums));
		int[] nums2 = new int[] { 1, 2, 0, 2, 2, 1, 0, 1, 0, 0, 1 };
		//sortColors(nums2, nums.length);
		System.out.println(".." + Arrays.toString(nums2));
	}

	public static void sortColors(int[] nums) {
		/*
		 * idea is to first replace all 2s and put at end, when all 2s are
		 * at end the p2 pointer will be before all 2s so we dont touch 2's after that
		 * Note the index is not changed when we swap a 2 with someother element, because
		 * if I replaced with 0 then 0 will be analyzed further to save a pass
		 * for ex: in one go only : 122110[p2] => 10211[p2]2 => 01211[p2]2 => 0111[p2]22 
		 * => now p2 is poiting to the last 1 hence we are excluding 22 out of our sort
		 * 122110[p2] => 10211[p2]2       => 0p[1]1211[p2]2 	=> 0p[1]111[p2]22
		 *               0 come on idx=1        idx=1 has a 0 		idx=2 nothing to do
		 *               p2 points to L-1	  0 is on idx 0          
		 *               idx still is on 1    1 is on idx 1
		 *               					  p2 no change
		 *               					  p1 on idx 1		 
		 */
		int p1 = 0, p2 = nums.length - 1, index = 0;
		while (index <= p2) {
			if (nums[index] == 0) {
				nums[index] = nums[p1];
				nums[p1] = 0;
				p1++;
				index--;
			}
			if (nums[index] == 2) {
				nums[index] = nums[p2];
				nums[p2] = 2;
				p2--;
				index--;
			}
			index++;
		}
	}
// this is count sort not sure how it works
	static void sortColors(int A[], int n) {
		int red = -1, white = -1, blue = -1;
		for (int i = 0; i < n; i++) {
			if (A[i] == 0) {
				A[++blue] = 2;
				A[++white] = 1;
				A[++red] = 0;
				System.out.println("c1.."+Arrays.toString(A));
			} else if (A[i] == 1) {
				A[++blue] = 2;
				A[++white] = 1;
				System.out.println("c2.."+Arrays.toString(A));
			} else if (A[i] == 2)
				A[++blue] = 2;
			System.out.println("c3.."+Arrays.toString(A));
		}
	}
}
