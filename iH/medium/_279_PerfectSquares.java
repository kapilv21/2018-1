package GI.medium;

import java.util.Arrays;
public class _279_PerfectSquares {
	static int[] dp ;

	static int numSquares(int n) {
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; ++i) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, dp[i - j * j] + 1);
				++j;
			}
			dp[i] = min;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		numSquares(12);
		System.out.println("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12]");
		System.out.println(Arrays.toString(dp).replaceAll(",", "|"));
	}
}
