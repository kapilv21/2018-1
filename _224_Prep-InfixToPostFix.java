package hard;

import java.util.Stack;

public class A224_1InfixToPostFix {
	public static void main (String[] args) throws Exception{
		//System.out.println(infixToPostFix("1+(4-2)"));
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostFix(infix));
	}
	static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	static String infixToPostFix(String s) throws Exception {
		StringBuffer res = new StringBuffer();
		Stack<Character> st = new Stack<>();
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				res.append(c);
			}else if (c == '(') {
				st.push(c);
			}else if (c == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					char x = st.pop();
					if (x == ')') {
						throw new Exception("not good ");
					}
					res.append(x);
				}
				st.pop(); // throw away the ( bracket
			} else {
				while (!st.isEmpty() && prec(st.peek()) >= prec(c)) {
					res.append(st.pop());
				}
				st.push(c);
			}
		}
		while(!st.isEmpty()) {
			res.append(st.pop());
		}
		return res.toString();
	}
}
