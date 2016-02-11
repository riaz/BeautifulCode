package practice.ctci.stque;

public class StackToQueue {
	
	//this program used 2 stacks to function as a queue
	Stack inbox  = new Stack(100);
	Stack outbox = new Stack(100);
	
	public void enqueue(int data){
		inbox.push(data);
	}
	
	public int dequeue(){
		if(outbox.isEmpty()){
			while(!inbox.isEmpty())
				outbox.push(inbox.pop());
		}
		return outbox.pop();
	}
			

	public static void main(String[] args) {
		StackToQueue sq = new StackToQueue();
		
		sq.enqueue(10);
		sq.enqueue(20);
		sq.enqueue(30);
		
		System.out.println(sq.dequeue());
		
		sq.enqueue(40);
		sq.enqueue(50);
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		//output: 10 , 20, 30, 40		

	}

}
