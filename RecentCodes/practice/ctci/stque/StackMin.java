package practice.ctci.stque;

public class StackMin {
	Node top= null;
	int gmin = Integer.MAX_VALUE;
	
	public void push(int data){
		Node n;
		if(top==null){
			n= new Node(data,data); //no ther min may exist to compareTo
			gmin = data;
			top = n;			
		}
		else{
			gmin = Math.min(data, gmin);
			n = new Node(data,gmin);
			n.next = top;
			top = n;
		}
	}
	
	public Node peek(){
		return top;
	}
	
	public int min(){
		return peek().min;
	}
	
	public int pop(){
		if(top == null){
			System.out.println("This is an invalid operation");
			return -1;
		}
		else
		{
			int popped = top.data;
			if(top.next == null){
				gmin = Integer.MAX_VALUE;
				int data = top.data;
				top = null;
				return data;
			}else{
				int data = top.data;
				top = top.next;
				gmin = peek().min;
				return data;
			}
			
		}
	}
	
	//program to perform push,pop and min in constant time, every time a new node is stored the minimum is 
	class Node{
		int data;
		int min;
		Node next=null;
		
		Node(int data,int min){
			this.data = data;
			this.min = min;
		}
	}
	
	public static void main(String[] args) {
		StackMin obj = new StackMin();
		
		obj.push(20);
		obj.push(30);
		obj.push(10);
		obj.push(40);
		obj.pop();
		obj.pop();
		System.out.println(obj.min());
		
	}
}
