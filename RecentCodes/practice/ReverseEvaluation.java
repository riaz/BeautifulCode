package practice;

/* Implementing evaluation of a reverse polish
 * notation using a stack */

import java.util.Stack;

public class ReverseEvaluation {
	static Stack<String> stack  = new Stack<String>();;
	
	
	public static void main(String[] args){
		//String[] tokens = new String[]{"2","1","+","3","*"};  //ans: 9
		String[] tokens = new String[]{"4","13","5", "/" ,"+"}; //ans: 6
		
		System.out.println(evalRPN(tokens));
	}
	
	public static int evalRPN(String[] tokens){
		int value = 0;
		String operators = "+-*/";
		
		for(int i = 0;i<tokens.length;i++){
			String s = tokens[i];
			
			if(operators.indexOf(s) >= 0){
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				
				System.out.println(a + " " + b + "  " +  s);
				
				value = getValue(a, b , s);
				stack.push(new Integer(value).toString());
			}
			else{
				stack.push(s);
			}
			
		}
		
		return value;
	}
	
	public static int getValue(int a,int b,String op){
		int res = 0;
		
		if(op.equals("+"))
			res = a + b;
		else if(op.equals("-"))
			res = b - a;
		else if(op.equals("*"))
			res = a * b;
		else if(op.equals("/"))
			res = b / a;
		
		return res;				
	}
}
