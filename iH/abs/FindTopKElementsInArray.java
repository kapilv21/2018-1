package abs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindTopKElementsInArray {
	public static void main(String[] args) {
		// find k max elems from array
		int[] ar = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 4;
		int size = k;
		PriorityQueue<Integer> pq = new PriorityQueue<>(size);
		for (int e : ar) {
			if (pq.size() >= k) {
				if (e > pq.peek()) {
					pq.poll();
					pq.offer(e);
				}
			}else {
				pq.offer(e);
			}
		}
		System.out.println(Arrays.toString(pq.toArray()));
		while (k > 0) {
			System.out.println(pq.poll());
			k--;
		}

		// int[] a = new int[] { 7, -2, -3,12,-19, 4, -1, -2, 1, 5, -3 };
		int[] a = new int[] { -1, -2, 9, -1, -5, -6 };
		int curr_sum = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if ((curr_sum + a[i]) < 0) {
				curr_sum = 0;
				continue;
			} else {
				curr_sum += a[i];
				System.out.println(a[i] + " cur " + curr_sum);
			}
			max = Math.max(curr_sum, max);
		}
		System.out.println(" max " + max);

	}
}
