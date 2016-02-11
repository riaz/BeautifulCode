package practice.ctci.stque;

public class Queue {
	Node first,last;
	
	Queue(){
		first = last = null;		
	}
	
	void enqueue(int item){
		if(first == null){
			last = new Node(item);
			first = last;
		}
		else{
			Node node = new Node(item);
			last.next = node;
			last = node;
		}			
	}
	
	int dequeue(){
		if(first != null){
			int data = first.data;
			first = first.next;
			return data;
		}		
		return -1;			
	}
	
	public static void main(String[] args) {
			Queue q = new Queue();
			q.enqueue(10);
			q.enqueue(20);
			q.enqueue(30);
			System.out.println(q.dequeue());
			q.enqueue(40);
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			
			//out: 10,20,30,40
		
	}

}
