package abs;

import java.util.Set;

public class LongestConcecutiveSubSeqInArray {
	public static void main(String args[]) {
		int arr[] = new int[] { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
		System.out.println(" find max " + findMaxSub(arr));
	}

	private static int findMaxSub(int ar[]) {
		int before = 0;
		int after = 0;
		int maxCount = 0;
		// load to set but special type of set, with HashSet you will get
		// Concurrent modification exception
		Set<Integer> set = new java.util.HashSet<>();

		for (int x : ar) {
			set.add(x);
		}

		for (int y : set) {
			int count = 0;
			before = y - 1;
			after = y + 1;

			set.remove(y);
			count++;
			while (set.contains(before)) {
				set.remove(before);
				before--;
				count++;
			}

			while (set.contains(after)) {
				set.remove(after);
				after++;
				count++;
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

}
