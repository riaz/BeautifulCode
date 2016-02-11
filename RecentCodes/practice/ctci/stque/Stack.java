package practice.ctci.stque;

class Node{
	int data;
	Node next=null;
	
	Node(int data){
		this.data = data;
	}	
}

public class Stack {
	Node top;
	int cap;
	int count;
	
	Stack(int cap){
		this.cap = cap;
	}
	
	int pop(){
		Node node = top;
		if(top.next!=null){
			int data = top.data;
			top = top.next;
			count--;
			return data;
			
		}
		return -1;
	}
	
	public void push(int item){
		if(!isFull()){
			Node node = new Node(item);
			node.next = top;
			top = node;	
			count++;
		}
	}
	
	public boolean isFull(){
		return  count == cap;
	}
	
	public boolean isEmpty(){
		return  count == 1;
	}
	
	public int peek(){
		return top.data;
	}
	
	public static void main(String[] args) {
		
		//writing a stack client to test the stack.
		Stack s = new Stack(20);
		
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(40);
		System.out.println(s.pop());
		
		//output: 30,20,40		
	}

}
