package abs;

public class Fibonacci {
	public static void main(String[] args) {
		//genFib(5);
		System.out.println(genFibRec(5));
	}
	static void genFib(int n){
		int i=0;int[] res=new int[n+1];
		while(i<=n){
			if(i<=1){
				System.out.print(i+" ");
				res[i] = i;
			}else{
				res[i]=res[i-1]+res[i-2];
				System.out.print(" " +res[i]);
			}
			i++;
		}
	}
	public static int genFibRec(int n){
		if(n<=1){
			return n;
		}
		return genFibRec(n-1)+genFibRec(n-2);
	}
}
