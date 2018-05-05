package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _247_StroboGrammatic_Number {
	public static void main(String[] args) {
		List<String> sList = findStrobogrammatic(3);
		System.out.println(" .. "+Arrays.toString(sList.toArray()));
		List<String> sList2 = findStrobogrammatic2(3);
		System.out.println(" .. "+Arrays.toString(sList.toArray()));
	}
	static  List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        if(n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        char[] arr = new char[n];
        generator(arr, 0, n - 1, res);
        return res;
    }
	static void generator(char[] arr, int s, int e, List<String> ls){
        if(s > e) {
            ls.add(String.valueOf(arr));
            return ;
        }
        char[][] allNum = {{'0','0'}, {'1','1'}, {'8','8'}, {'6','9'}, {'9','6'}};
        for(int i = (s == 0)? 1 : 0; i < (s == e ? 3 : 5); i++) {
            arr[s] = allNum[i][0];
            arr[e] = allNum[i][1];
            generator(arr, s + 1, e - 1, ls);
        }
    }
	
	static  List<String> findStrobogrammatic2(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        if(n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        char[] arr = new char[n];
        generator(arr, 0, n - 1, res);
        return res;
    }
	static void generator2(char[] arr, int s, int e, List<String> ls){
        if(s > e) {
            ls.add(String.valueOf(arr));
            return ;
        }
        arr[s] = 0; arr[e] = 0;
        generator(arr, s + 1, e - 1, ls);
        arr[s] = 1; arr[e] = 1;
        generator(arr, s + 1, e - 1, ls);
        arr[s] = 8; arr[e] = 8;
        generator(arr, s + 1, e - 1, ls);
        arr[s] = 6; arr[e] = 9;
        generator(arr, s + 1, e - 1, ls);
        arr[s] = 9; arr[e] = 6;
        generator(arr, s + 1, e - 1, ls);
    }
}
