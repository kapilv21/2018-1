package abs;

public class XORInArray {
	public static void main(String[] args) {
		int[] ar = new int[]{3,3,16,16,12,12,10};
		// make sure we store first elem in result
		// if we initialize result with 0 then it affects
		int result = ar[0];
		for(int i=1; i<ar.length; i++){
			result = result^ar[i];
		}
		System.out.println(result);
	}
}
