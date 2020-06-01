package fb;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        String sb = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                continue;
            }
            
            if(c == '*' || c == '/' || c == '+' || c == '-'){
            		if(sb.length() > 0) {
            			operand.push(Integer.parseInt(sb));
            			if(!operator.isEmpty()) {
            				if(c == '+' || c == '-') {
            					char op = operator.pop();
            		            int op2 = operand.pop();
            		            int op1 = operand.pop();
            		            int result = 0;
            		            if(op == '+'){
            		                result = op1 + op2;
            		            } else if(op == '-'){
            		                result = op1 - op2;
            		            } else if(op == '*') {
            		            		result = op1 * op2;
            		            } else if(op == '/') {
            		            		result = op1 / op2;
            		            }
            		            operand.push(result);
            				}
            				
            				if(!operator.isEmpty() && (operator.peek() == '/' || operator.peek() == '*')){
                                char op = operator.pop();
                                int op2 = operand.pop();
                                int op1 = operand.pop();
                                int result = 0;
                                if(op == '/'){
                                    result = op1 / op2;
                                } else{
                                    result = op1 * op2;
                                }
                                operand.push(result);
                            }
              		}
            			operator.push(c);
                        sb = "";
            		}
            } else{
                sb += c;
            }
        }
        
        if(sb.length() > 0){
            Integer sbInt = Integer.parseInt(sb);
            operand.push(sbInt);

            if(!operator.isEmpty() && (operator.peek() == '/' || operator.peek() == '*')){
                char op = operator.pop();
                int op2 = operand.pop();
                int op1 = operand.pop();
                int result = 0;
                if(op == '/'){
                    result = op1 / op2;
                } else{
                    result = op1 * op2;
                }
                operand.push(result);
            }
            
        }
        
        while(!operator.isEmpty()){
            char op = operator.pop();
            int op2 = operand.pop();
            int op1 = operand.pop();
            int result = 0;
            if(op == '+'){
                result = op1 + op2;
            } else{
                result = op1 - op2;
            }
            operand.push(result);
        }
        
        return operand.pop();
    }
	
	public static void main(String[] args) {
		int result = new BasicCalculator().calculate("2*3+4");
		System.out.println(result);
	}
}