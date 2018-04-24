package hard;

import java.util.ArrayList;
import java.util.List;

public class _282_Expression_Add_Operators {
	static int target = 6;
	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {
		int y[] = new int[1];
		// eval("123".toCharArray(), 0, res);
		System.out.println(y[0]);

		/*
		 * for(Integer x: res) { System.out.println(x); }
		 */

		/*addOperators("123", 6);

		for (String x : result) {
			System.out.println(x);
		}*/
		calc("123".toCharArray(), 0, 0, "",'+');
	}

	// NOT working for 0 in a number edge case only
	static void calc(char[] num, int i, int n, String trace, char op) {
		String t = "";
		int x = (num[i]-'0');
		if(i>0) {
			t=trace+op;
		}
		if(op=='+') {n = n+x;}if(op=='-') {n = n-x;}if(op=='*') {n = n*x;}
		if(i==num.length-1) {
			System.out.println("..print "+t+num[i]+ " sum "+n);
			if(n == target) {
				System.out.println(" **********achieved "+t+num[i]);
			}
			return;
		}
		calc(num, i+1,  n, t+x, '+');
		calc(num, i+1,  n, t+x, '-');
		calc(num, i+1,  n, t+x, '*');
	}
	static void eval(char[] num, int i, List<Integer> list) {
		if (i == num.length - 1) {
			list.add(num[i] - '0');
			return;
		}
		eval(num, i + 1, list);
		List<Integer> curr = new ArrayList<>();
		for (Integer elem : list) {
			curr.add(num[i] - '0' + elem);
			curr.add(num[i] - '0' - elem);
			curr.add((num[i] - '0') * elem);
			System.out.println(" .." + (num[i] - '0') + "+" + elem);
			System.out.println(" .." + (num[i] - '0') + "-" + elem);
			System.out.println(" .." + (num[i] - '0') + "*" + elem);
		}
		list.clear();
		list.addAll(curr);
	}

	static List<String> result = new ArrayList<String>();

	static List<String> addOperators(String num, int target) {
		for (int i = 1; i <= num.length(); i++) {
			if (i >= 2 && num.charAt(0) == '0')
				continue;
			bfs(num.substring(i), num.substring(0, i), target, 0, Long.parseLong(num.substring(0, i)), true);
		}
		return result;
	}

	static void bfs(String s, String trace, int target, long pre, long current, boolean sign) {
		System.out.println(" calling with s "+s+" trace "+trace+" pre "+pre+" curr "+current);
		long sum = sign ? pre + current : pre - current;
		if (s.length() == 0) {
			if (sum == (long) target)
				result.add(trace);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			System.out.println(" still conf i "+i+" curr s "+s);
			if (i >= 2 && s.charAt(0) == '0')
				continue;
			int number = Integer.parseInt(s.substring(0, i));
			bfs(s.substring(i), trace + "+" + number, target, sum, number, true);
			bfs(s.substring(i), trace + "-" + number, target, sum, number, false);
			bfs(s.substring(i), trace + "*" + number, target, pre, current * number, sign);
		}
	}
	/*static void calc(char[] num, int i, int n, int prev, String trace, char op) {
		String t = "";
		int x = (num[i]-'0');
		if(i>0) {
			t=trace+op;
		}
		int temp = n;
		if(op=='+') {n = n+x;}if(op=='-') {n = n-x;}if(op=='*') {n = n*x;}
		if(i==num.length-1) {
			System.out.println("..print "+t+num[i]+ " sum "+n);
			if(n == target) {
				System.out.println(" **********achieved "+t+num[i]);
			}
			return;
		}
		if((i+1)<num.length && num[i+1]==0) {
			calc(num, i+1,  temp+x*10, 0, trace+"0"+op, '+');
			calc(num, i+1,  temp+x*10, 0, trace+"0"+op, '-');
			calc(num, i+1,  temp+x*10, 0, trace+"0"+op, '*');
		}
			calc(num, i+1,  n, x, t+x, '+');
			calc(num, i+1,  n, x,  t+x, '-');
			calc(num, i+1,  n,  x, t+x, '*');
	}*/
}
