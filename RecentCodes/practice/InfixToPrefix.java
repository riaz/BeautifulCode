package practice;

public class InfixToPrefix {
	class Stack{
		int top;
		char[] stack; 
		
		Stack(){
			top = -1;
			stack = new char[1000];
		}
		
		public boolean isEmpty(){
			return top == -1;
		}
		
		public char top(){
			if(top == -1) return '0';
			else
				return stack[top];
		}
		
		public void push(char c){
			stack[++top] = c;
		}
		
		public char pop(){
			if(top == -1){
//				System.out.println("Stack is empty");
				return '$'; //end of stack indicator
			}
			else{
				return stack[top--];
			}
		}
	}
	
	public int getPriority(char c){
		if(c == '(' || c == ')')
			return 1;
		else if(c == '+' || c == '-')
			return 2;
		else if(c == '*')
			return 3;
		else if(c == '/')
			return 4;
		else
			return 0; //will hold for other characters
	}
	
	
	public String getPrefix(String s){
		StringBuilder res = new StringBuilder();	
		String query = new StringBuilder(s).reverse().toString();
		
		Stack x = new Stack();
		
		for(int i=0;i<query.length();i++){
			char c = query.charAt(i);
			
			System.out.println(res);
			
			if(Character.isLetterOrDigit(c)){
				res.append(c);
			}else{
				//if(!x.isEmpty()){					
					if(c == '(')
					{
						while(x.top() != ')')
							res.append(x.pop());
						x.pop();							
					}
					else if(getPriority(x.top()) > getPriority(c))
					{
						while(c!= '(' && getPriority(x.top()) > getPriority(c)){
								res.append(x.pop());
						}
					}
					else{
						x.push(c);
					}
						
				//}					
			}			
		}		
		while(!x.isEmpty())
			res.append(x.pop());
		
		return res.toString();		
	}
	
	public static void main(String[] args){
		String s = "((A-B)+C*(D+E))-(F+G)";
		System.out.println(new InfixToPrefix().getPrefix(s));
	}
}
