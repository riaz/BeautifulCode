package practice;

import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {
	
	HashMap<Character,Character> map;
	Stack<Character> stack;
	
	ValidParantheses(){
		map = new HashMap<Character,Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		
		stack = new Stack<Character>();
	}
	
	public boolean isValid(String s){
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			
			if(map.keySet().contains(c)){
				stack.push(c);
			}else if(map.values().contains(c)){
				if(!stack.isEmpty() && map.get(stack.peek()) == c){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}
		return stack.empty();
	}
	
	
	public static void main(String[] args) {
		//Samples
		
		String s1 = "{}{}[](){}";
		String s2 = "{}[][{}]()";
		String s3 = "{}[(])[]";
		
		
		System.out.println(s1 + " : " + new ValidParantheses().isValid(s1));
		System.out.println(s2 + " : " + new ValidParantheses().isValid(s2));
		System.out.println(s3 + " : " + new ValidParantheses().isValid(s3));
			
	}

}
