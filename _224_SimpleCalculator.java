package hard;

import java.util.Stack;

public class A224_SimpleCalculator {
	public static void main(String[] args) throws Exception {
		int x = calculate("(1-(4+5-2))");
		System.out.println("result "+x);
	}
	static int calculate(String str) throws Exception {
		String s = A224_1InfixToPostFix.infixToPostFix(str);
		Stack<Integer> st = new Stack<Integer>();
		int result  = 0;
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				st.push(c-'0');
			}else { 
				int sign = c == '-' ? -1 : 1;
				result+=sign*st.pop()+st.pop();
				st.push(result);
				result = 0;
			}
		}
		return st.pop();
	}
	static int calculate1(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			System.out.println(" stack "+stack.toString());
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = 10 * number + (int) (c - '0');
			} else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				// we push the result first, then sign;
				stack.push(result);
				stack.push(sign);
				// reset the sign and result for the value in the parenthesis
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				System.out.println(" peek "+stack.peek());
				result *= stack.pop();
				// stack.pop() is the sign before the parent
				result += stack.pop();
				// stack.pop() now is the result calculated before the parenthesis
			}
		}
		if (number != 0)
			result += sign * number;
		return result;
	}
}
