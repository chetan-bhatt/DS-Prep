package fb;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String sb) {
		Stack<Integer> digits = new Stack<>();
		Stack<String> stack = new Stack<>();

		String s = "";
		String d = "";
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (Character.isDigit(c)) {
				d += c;
			} else if (c == '[') {
				if (d.length() > 0) {
					digits.push(Integer.parseInt(d));
				}
				if (s.length() > 0) {
					stack.push(s);
				}
				stack.push(c + "");
				s = "";
				d = "";
			} else if (c == ']') {
				stack.push(s);
				String temp = "";
				while (!stack.peek().equals("[")) {
					temp = stack.pop() + temp;
				}
				stack.pop();
				if (!digits.isEmpty()) {
					int num = digits.pop();
					String t = "";
					for (int j = 0; j < num; j++) {
						t += temp;
					}
					stack.push(t);
				} else {
					stack.push(temp);
				}
				s = "";
			} else {
				s += c;
			}
		}
		if (s.length() > 0) {
			stack.push(s);
		}

		while (!digits.isEmpty()) {
			int num = digits.pop();
			String t = stack.pop();
			for (int i = 0; i < num; i++) {
				t += t;
			}
			stack.push(t);
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		return result;
	}
}