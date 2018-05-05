package GI.hard;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class _327_CountRangeSum {
	
	public static void main(String[] args) {
		int i = countRangeSum(new int[] {-2,5,-1}, -2, 2);
	System.out.println(i);
	}

	static int countRangeSum(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    System.out.println(" sums table "+Arrays.toString(sums));
	    int ans = 0;
	    for (int i = 0; i < n; ++i)
	        for (int j = i + 1; j <= n; ++j)
	            if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper) {
	            	System.out.println(" positive i "+i+" j "+j);
	            	ans++;
	            }
	    return ans;
	}
}
