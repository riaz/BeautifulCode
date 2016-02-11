package threads;

public class ThreadDemo extends Thread{
	public void run(){
		System.out.println("Welcome to the thread");
	}
	
	public static void main(String[] args){
		Thread t = Thread.currentThread();
		
		System.out.println("Current Thread : " + t.getName());
		t.setName("Riaz Thread");
		
		System.out.println("Current Thread : " + t.getName());
				
		new ThreadDemo().start();
		
		try{
			for(int i=0;i<10;i++){
				System.out.println(i);
				Thread.sleep(2000);
			}
		}catch(InterruptedException ie){
			System.out.println("The main thread was interrupted");
		}
		
	}
}
