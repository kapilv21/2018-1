package abs;
/*
 * Its important to note base cases where array size is 1 or 2
 * also what about duplicates?
 * when all elements are incr only like 1,2,3,4 then ans is 4
 * when all decreasing like 120,6,5,4  ans is 120
 * 
*/
public class MaxInArrayThatIsIncreasingThenDecreasing {
	public static void main(String[] args) {
		//int ar[] = new int[] {1, 3, 50, 50, 9, 7, 6};
		int ar[] = new int[] {1, 3, 50, 70,70};
		System.out.println(getIndex(ar, 0, ar.length - 1));
		System.out.println(getIndex(ar));

	}
	// simplified only condition to check is the 3rd one, rest is ok
	static int getIndex(int[] ar){
		int hi = ar.length-1; int low=0;
		while(hi>=low){
			int mid = (hi+low)/2;
			// when there are only 2 elements
			if(hi-low ==1 ){
				System.out.println(" here");
				return ar[hi]>=ar[low] ? hi : low;
			}
			// when only one element
			if(low == hi){
				System.out.println(" in low");
				return low;
			}
			// we check mid should be 2nd or 2nd last element and mid is bigger than its neighbours
			// mid>=ar[mid-1] is for duplicate handling, and also makes sure the last of 2 index is sent
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

	static int getIndex(int[] ar, int low, int hi) {
		int mid = (low + hi) / 2;
		
		// when array has only one element, or on boundries
		if(low == hi){
			return low;
		}
		// when array has 2 elements, or left with 2 elem on right or left
		if(hi-low == 1){
			return ar[hi]>ar[low] ? hi : low;
		}
		if (low > hi || (mid + 1)>ar.length-1 || (mid-1) < 0) {
			return -1;
		}
		if (ar[mid] > ar[mid + 1] && ar[mid] >= ar[mid - 1]) {
			return mid;
		}

		if (ar[mid] >= ar[mid - 1] && ar[mid] <= ar[mid + 1]) {
			return getIndex(ar, mid + 1, hi);
		} else if (ar[mid] <= ar[mid - 1] && ar[mid] >= ar[mid + 1]) {
			return getIndex(ar, low, mid - 1);
		}
		return -1;
	}
}
