package abs;

import java.util.Arrays;

public class RetrieveSortedArrayFromRotatedArray {
	public static void main(String[] args) {
		int[] ar = new int[]{4,5,6,7,7,1,2,3,3};
		getSortedArray(ar);
	}
	
	static void getSortedArray(int[] ar){
		int rotationPoint=getIndex(ar);
		reverse(0,rotationPoint, ar);
		reverse(rotationPoint+1, ar.length-1, ar);
		reverse(0, ar.length-1, ar);
		System.out.println("..."+Arrays.toString(ar));
	}
	public static void reverse(int low, int hi, int[] ar){
		while(hi>low){
			int temp = ar[low];
			ar[low] = ar[hi];
			ar[hi] = temp;
			hi--;
			low++;
		}
	}
	static int getIndex(int[] ar){
		int hi = ar.length-1; int low=0;
		while(hi>=low){
			int mid = (hi+low)/2;
			if(mid >0 && ar[mid]>=ar[mid-1] && mid< ar.length-1 && ar[mid]>ar[mid+1]){
				return mid;
			}
			if(ar[mid] < ar[low]){
				hi = mid-1;
			}else{
				low = mid+1;
			}
		}
		return -1;
	}
}
