package threads;

public class MultipleThreads extends Thread{
	
	MultipleThreads(String name){		
		super(name);
		System.out.println("Initilizing Thread : " + this);
		start();		
	}
	
	public void run(){
		try{
			for(int i=5;i>0;i--){
				System.out.println("Inside Thread " + i);
				Thread.sleep(500);
			}
			System.out.println("Exiting thread "+ this.getName());
		}catch(InterruptedException ie){
			System.out.println("Thread " + this.getName() + " was interrupted");
		}
	}
	
	public static void main(String[] args){
		MultipleThreads ob1 = new MultipleThreads("One");
		MultipleThreads ob2 = new MultipleThreads("Two");
		MultipleThreads ob3 = new MultipleThreads("Three");
		
		try{
			System.out.println("Inside Main Thread");
 			//Thread.sleep(10000); - not ideal

			//using joins
			ob1.join();
			ob2.join();
			ob3.join();
			
			System.out.println("Exiting Main Thread");			
		}catch(InterruptedException ie){
			System.out.println("The main thread was interrupted");
		}
	}
}
