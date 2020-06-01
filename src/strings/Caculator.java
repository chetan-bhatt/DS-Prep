package strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Caculator {
	public int calculate(String s) {
        
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		Set<Character> set = new HashSet<>();
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');

		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
			while(s.charAt(start) == ' ') {
				start++;
			}
			if (set.contains(c) || c == ' ') {
				if(c == ' ') {
					String temp = s.substring(start, i);
					String t = "";
					for(int j = start; j < start + temp.length(); j++) {
						if(temp.charAt(j) != ' ') {
							t += temp.charAt(j);
						}
					}
					stack1.push(Integer.valueOf(t));
					start = i + 1;
				} else {
					stack1.push(Integer.valueOf(s.substring(start, i)));

				}
				if(set.contains(c))
					stack2.push(c);
			}
		}
		
		String endString = s.substring(start, s.length());
		System.out.println(" end String = " + endString);

		String end = "";
		for(int i = 0; i < endString.length(); i++) {
			if(endString.charAt(i) != ' ') {
				end += endString.charAt(i);
			}
		}
		System.out.println(" end = " + end);
		stack1.push(Integer.valueOf(end));

	    return calc(stack1, stack2);
    }
    
    private int calc(Stack<Integer> stack1, Stack<Character> stack2){
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
        int right = stack1.pop();
        int left = stack1.pop();
        char operator = stack2.pop();
        switch (operator) {
            case '+':
				stack1.push(left + right);
				break;
			case '-':
				stack1.push(left - right);
				break;
			case '*':
				stack1.push(left * right);
				break;
			case '/':
				stack1.push(left / right);
				break;
			}
		}

		return stack1.pop();
    }
	
	public static void main(String[] args) {
		//System.out.println(new Caculator().calculate(" 3+5 / 2 "));
		String str = "a";
		 char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	        System.out.println(ns);
	}
}