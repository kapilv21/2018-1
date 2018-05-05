package abs;

import java.util.Arrays;

public class CharArrayAddOne {
	public static void main(String[] args) {
		char[] car = new char[] { '9', '9' };
		char[] result = new char[car.length + 1];
		int carry = 1;
		for (int i = car.length - 1; i >= 0; i--) {
			int curr = car[i] - '0';
			int sum = carry + curr;
			carry = sum / 10;
			result[i + 1] = (char) (sum % 10 + '0');
		}
		if (carry > 0) {
			result[0] = (char) (carry + '0');
		}
		System.out.println(Arrays.toString(result));
	}
}
