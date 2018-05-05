package abs;

import java.util.Arrays;

public class Missing {
	public static void main(String[] args) {
		int[] ar = new int[] { 9, 9, 9, 9 };
		int[] result = new int[ar.length + 1];
		// increment number by 1
		int carry = 1;
		int j = result.length - 1;
		for (int i = ar.length - 1; i >= 0; i--) {
			int res = (ar[i] + carry) % 10;
			carry = (ar[i] + carry) / 10;
			result[j] = res;
			j--;
		}
		// add the last carry in the first digit
		result[0] = carry;
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(result));
	}
}
