package threads;

public class NonPreemtive implements  Runnable{
	private Thread t;
	private long rounds = 0;
	
	NonPreemtive(String name,int priority){
		t = new Thread(this,name);
		t.setPriority(priority);
		t.start();
	}
	
	public void run(){
		while(true){
			rounds++;
		}
	}
	
	public long getRounds(){
		return this.rounds;
	}
	
	public Thread getThread(){
		return this.t;
	}
	
	public static void main(String[] args){
		//Main run two threads with NORMAL_PRIORITY -2 and
		//Normal Priority + 2 for 10 seconds and
		///displays the click count
		
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		NonPreemtive th1 = new NonPreemtive("One",Thread.NORM_PRIORITY+2);
		NonPreemtive th2 = new NonPreemtive("Two",Thread.NORM_PRIORITY-2);
		
		try{
			System.out.println("Entering thread main");
			Thread.sleep(5000); //waiting 5 milliseconds for th1 and th2 to run;
			
			th1.getThread().join();
			th2.getThread().join();			
			
			System.out.println(th1.getThread().getName() + " executes " + th1.getRounds() + " times." );
			System.out.println(th2.getThread().getName() + " executes " + th2.getRounds() + " times." );
			
			System.out.println("Main Thread Terminates");
		}catch(InterruptedException ie){
			System.out.println("The main method was interrupted");
		}
		
		
	}
}
