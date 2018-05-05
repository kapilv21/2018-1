package abs;

/*
 * find max sum subarrya, meaning find a subarray of continuous items which yields max sum
 * so for ex: here 3,4,-5,6 yields 8 which is max
 * note: we cannot eliminate intermediate elements like -5 so to yield 13, because we look for max sub array
 * subarray = continuous elements

*/
public class KadanesMaxSumSubArray {
	public static void main(String[] args) {

		int[] ar = new int[] { -1, -2, 3, 4, -5, 6 };
		System.out.println(kadanes(ar));
		
		Intervalx inter = kadanesWithIntervalx(ar);
		System.out.println(" Intervalx "+inter.start+", "+inter.end+" => "+inter.value);
	}

	/*
	 * we run through array one time we find sum at ever element . 
	 * Rule is we have 2 variables, current max and the max 
	 * everytime we maintain sum in max_curr, and at every element we need to see if max_curr was negative, if yes no advantage to add it to curr element hence curr element is max_curr
	 * then we compare mar_curr to max and keep whatever was max
	 */
	static int kadanes(int[] ar) {
		int max = Integer.MIN_VALUE;
		int max_curr = Integer.MIN_VALUE;
		
		for (int i = 0; i < ar.length; i++) {
			//check if max_curr is negative, if yes reset
			if(max_curr < 0){
				max_curr = ar[i];
			}else{
				max_curr += ar[i];
			}
			max = Math.max(max_curr, max);
			
		}
		return max;
	}

	/*
	run result
	elements		-1   -2	  3	  4	  -5    6
	max_curr        -1   -2   3   7    2    8 
	max				-1   -1   3   7    7    8
*/
	static Intervalx kadanesWithIntervalx(int[] ar) {
		Intervalx max = new Intervalx(-1, -1, Integer.MIN_VALUE);
		Intervalx max_curr = new Intervalx(-1, -1, Integer.MIN_VALUE);
		
		for (int i = 0; i < ar.length; i++) {
			//check if max_curr is negative, if yes reset
			if(max_curr.value < 0){
				max_curr = new Intervalx(i, i, ar[i]);
				
			}else{
				max_curr = new Intervalx(max_curr.start, i, (max_curr.value +ar[i]));
			}
			if(max_curr.value >= max.value){
				max = max_curr;
			}
			
		}
		return max;
	}
}
class Intervalx{
	int start;
	int end;
	int value;
	public Intervalx(int start, int end, int value){
		this.start = start;
		this.end = end;
		this.value = value;
	}
}