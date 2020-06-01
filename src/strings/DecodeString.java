package strings;

import java.util.Stack;

public class DecodeString {

	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		// Queue<Character> queue = new LinkedList<>();
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				stack.push(c + "");
			} else if (c == '[') {
				stack.push(c + "");
			} else if (c == ']') {
				String temp = "";
				while (!stack.peek().equals("[")) {
					String t = stack.pop();
					int num = getNum(temp);
					if(num == -1)
						temp = t + temp;
					else {
						for(int j = 1; j < num; j++) {
							temp = t + temp;
						}
					}
				}
				stack.pop();
				stack.push(temp);
			} else {
				stack.push(c + "");
			}
		}

		String result = "";
		while (stack.isEmpty()) {
			String st = stack.pop();
			int num = getNum(st);
			if (num == -1) {
				result = st + result;
			} else {
				for (int i = 1; i < num; i++) {
					result = st + result;
				}
			}
		}

		return result;
	}

	private static int getNum(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		//String s = "3[2[c]]";
		//System.out.println(decodeString(s));
		System.out.println((char)(2 + 'a'));
	}
}
