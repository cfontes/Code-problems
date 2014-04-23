package ojleet.problems;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	
    	Stack<Integer> numbers = new Stack<Integer>();
    	Integer oper1=null;
        Integer oper2=null;

        for(String token : tokens){
        	switch(token){
        		case "+":
        			oper1 = numbers.pop();
        			oper2 = numbers.pop();
        			numbers.push(oper2 + oper1);
        			break;
        		case "-":
        		    oper1 = numbers.pop();
        			oper2 = numbers.pop();
        			numbers.push(oper2 - oper1);
        			break;
        		case "*":
        		    oper1 = numbers.pop();
        			oper2 = numbers.pop();
        			numbers.push(oper2 * oper1);
        			break;
        		case "/":
        			oper1 = numbers.pop();
        			oper2 = numbers.pop();
        			if(oper2 != 0){
        				numbers.push(oper2 / oper1);
        			}else{
        				numbers.push(0);
        			}
        			break;
        		default:
        		    numbers.push(Integer.parseInt(token));
        	}
        }
        return numbers.peek() != null ? numbers.pop() : 0;
    }
}