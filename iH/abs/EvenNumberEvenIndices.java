package abs;

public class EvenNumberEvenIndices {
	 public static void main(String[] args) {
		 int[] ar = new int[] { 1 , 3 , 5 , 8 , 10 , 13 , 18 , 36 , 78 };
		 for(int i=0; i< ar.length; i++){
			 if(i%2 ==0 && ar[i]%2 ==0){
				 System.out.println(ar[i]);
			 }
		 }

	 }
}
