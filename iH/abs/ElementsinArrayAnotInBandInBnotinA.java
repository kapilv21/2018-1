package abs;

public class ElementsinArrayAnotInBandInBnotinA {
	public static void main(String[] args) {
		int[] a1 = new int[] { 1, 2, 2, 2, 3, 6, 7 };
		int[] a2 = new int[] { 2, 4, 5, 10, 12, 13, 14, 15 };
		findDiff(a1, a2);
	}

	static void findDiff(int[] a1, int[] a2) {
		int i = 0, j = 0;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (i < a1.length && j < a2.length) {
			// first array elem is smaller add to the sb1
			if (a1[i] < a2[j]) {
				sb1.append(a1[i]);
				i++;
			// below case to ignore elements that are equal
			} else if (a1[i] == a2[j]) {
				i++;
				j++;
			// below for second element smaller than first array elem
			} else {
				sb2.append(a2[j]);
				j++;
			}
		}
		// to exhaust the array
		while (i < a1.length) {
			sb1.append(a1[i]);
			i++;
		}
		// to exhaust the array
		while (j < a2.length) {
			sb2.append(a2[j]);
			j++;
		}
		System.out.println(sb1);
		System.out.println(sb2);
	}

}
