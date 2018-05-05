package GI.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _321_CreateMaxNumber {
	public static void main(String[] args) {
		Integer[] nums1 = new Integer[] {3, 4, 6, 5};
		Integer[] nums2 = new Integer[] {9, 1, 2, 5, 8, 3};
		//int[] y = maxNumber(nums1, nums2, 3); System.out.println(Arrays.toString(y));
		myMethod(nums1, nums2, 3); 
	}
	
	static void myMethod(Integer[] nums1, Integer[] nums2, int k) {
		Arrays.sort(nums1, Collections.reverseOrder());
		Arrays.sort(nums2, Collections.reverseOrder());
		int result = 0;
		for(int i=0; i<k; i++) {
			Integer[] first = new Integer[i];
			Integer[] second = new Integer[k-i];
			for(int x = 0;x<i;x++)
				first[x] = nums1[x];
			for(int x = 0;x<k-i;x++)
				second[x] = nums2[x];
			//int[] mergedNum = maxMerge(first, second);
			Integer[] mergedNum = merge(first, second);
			StringBuffer sb = new StringBuffer();
			for(int m : mergedNum) {
				sb.append(m);
			}
			int currNum = Integer.valueOf(sb.toString());
			result = Math.max(result, currNum);
		}
		System.out.println(" max result  = "+result);
	}
	static Integer[] merge(Integer[] nums1, Integer[] nums2) {
		List<Integer> a = Arrays.asList(nums1);
		List<Integer> b = Arrays.asList(nums2);
		List<Integer> listFinal = new ArrayList<Integer>();
		listFinal.addAll(a);
		listFinal.addAll(b);
		Arrays.sort(listFinal.toArray());
		Integer[] finalList = (Integer[]) listFinal.toArray();
		return finalList;
	}
	static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] maxNum = new int[k];
		for (int i = 0; i <= k; i++) {
			System.out.println(" i == "+i);
			if (nums1.length >= i && nums2.length >= k - i) {
				System.out.println(" .. maxNumberSingleArray(nums1, i) "+i +" other "+(k-i));
				int[] merged = maxMerge(maxNumberSingleArray(nums1, i), maxNumberSingleArray(nums2, k - i));
				System.out.println("* => merged num "+Arrays.toString(merged));
				if (isGreater(merged, 0, maxNum, 0)) {
					maxNum = merged;
				}
			}
		}
		return maxNum;
	}

	// compute max number of a single array, given available numbers 'nums[]'' and
	// length 'len'
	// assume len <= nums.length
	static int[] maxNumberSingleArray(int[] nums, int len) {
		System.out.println("% maxNumberSingleArray "+len);
		int[] result = new int[len];
		int filledDigits = 0; // number of digits already filled
		for (int i = 0; i < nums.length; i++) {
			int j = filledDigits; // default position for current digit = index of last filled digit
			while (j > 0 && result[j - 1] < nums[i] && nums.length - i >= len - (j - 1)) {
				System.out.println("   now in j>0 loop "+j);
				// want to place larger numbers to as high digit as possible
				j--;
			}
			if (j < len) {
				result[j] = nums[i];
				filledDigits = j + 1;
			}
		}
		System.out.println("       returning "+Arrays.toString(result));
		return result;
	}

	// merge two number arrays to create a maximum number array
	// want to use digits from the array with the higher lexicographical order
	static int[] maxMerge(int[] arr1, int[] arr2) {
		System.out.println(" merging "+Arrays.toString(arr1) + " and "+Arrays.toString(arr2));
		int len = arr1.length + arr2.length;
		int[] result = new int[len];
		int i = 0, j = 0, k = 0;
		while (k < len) {
			result[k++] = isGreater(arr1, i, arr2, j) ? arr1[i++] : arr2[j++];
		}
		return result;
	}

	// compare which array contains a larger number, returns < 0 if arr1 < arr2, ==
	// 0 if equal, > 0 if arr1 > arr2
	static boolean isGreater(int[] arr1, int i, int[] arr2, int j) {
		while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
			i++;
			j++;
		}
		// arr1 is lexicographically greater if it has a longer length, or has a digit
		// greater than the digit as same place in arr2
		return i < arr1.length && j == arr2.length || (i < arr1.length && j < arr2.length && arr1[i] > arr2[j]);
	}
}