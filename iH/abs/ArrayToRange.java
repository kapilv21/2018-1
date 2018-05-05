package abs;

import java.util.Arrays;

public class ArrayToRange {
	
	public static void findMissing2(int[] ar){
		System.out.println(" ... ");
		int start = 0; int j =0 ; StringBuilder sb = new StringBuilder();
		if(ar[0] > 1){
			sb.append("0 - "+(ar[0]-1));
			start = ar[0];
			j = 1;
		}
		j = 1;
		start = 0;
		while(j<ar.length){
			System.out.println(" js "+j+" str "+start);
			
			// when diff is > 2 for ex 51 54 o/p 52-53
			if(ar[j] - ar[start] > 2){
				System.out.println(" for inded "+j);
				sb.append(", "+(ar[start]+1)+" - " +(ar[j] - 1));
			}else{
				// when diff ==2 ie 50 52 o/p has 51
				if(ar[j] - ar[start] == 2){
					System.out.println(" /// "+ar[start]+ " .. "+ar[j]);
					sb.append(", "+(ar[start]+1));
					
				}
			}
			start = j;
			j++;
		}
		if(ar[ar.length-1] < 98){
			sb.append((ar[ar.length-1]+1)+" - "+", 99");
		}else{
			sb.append(",99");
		}
		System.out.println(" output "+sb);
	}
	
	public static void findMissing3(int[] ar){
		System.out.println(" ... ");
		int start = 0; int j =0 ; StringBuilder sb = new StringBuilder();
		if(ar[0] > 1){
			sb.append("0 - "+(ar[0]-1));
			start = ar[0];
			j = 1;
		}
		while(j<ar.length){
			System.out.println(" js "+j+" str "+start);
			
			// when diff is > 2 for ex 51 54 o/p 52-53
			if(ar[j] - start > 2){
				System.out.println(" for inded "+j);
				sb.append(", "+(start+1)+" - " +(ar[j] - 1));
			}else{
				// when diff ==2 ie 50 52 o/p has 51
				if(ar[j] - start == 2){
					System.out.println(" /// "+start+ " .. "+ar[j]);
					sb.append(", "+(start+1));
					
				}
			}
			start = ar[j];
			j++;
		}
		if(ar[ar.length-1] < 98){
			sb.append((ar[ar.length-1]+1)+" - "+", 99");
		}else{
			sb.append(",99");
		}
		System.out.println(" output "+sb);
	}
	public static void main(String args[]) {
		int a[] = { 1, 2, 50, 52, 75, 98 };
		System.out.println(Arrays.toString(a));
		//System.out.println(getMissionList(a));
		findMissing3(a);
		findMissing2(a);
	}
	// FROM INTERNET
	
	public static String getMissionList(int array[]) {
		String m = "";
		if (array == null) {
			return null;
		}

		if (array.length == 0) {
			return "0-99";
		}

		int start = 0;
		// else do the following
		for (int index = 0; index < array.length; index++) {
			if (array[index] != start) {
				m += addMissing(index, array, start) + ",";
				start = array[index] + 1;
				System.out.println(" statr now "+start);
			} else {
				System.out.println(" othr "+start);
				start++;
			}
		}
		if (array[array.length - 1] != 99) {
			if (array[array.length - 1] == 98) {
				m += " 99 ";
			} else {
				m += (array[array.length - 1] + 1) + " -" + " 99 ";
			}
		}
		return m.substring(0, m.length() - 1);
	}

	private static String addMissing(int index, int array[], int start) {
		String missing = "";
		missing += start;
		System.out.println((start + 1) + " .. "+array[index]);
		if ((start + 1) != array[index]) {
			missing += " - " + (array[index] - 1);
		}
		return missing;
	}
}
