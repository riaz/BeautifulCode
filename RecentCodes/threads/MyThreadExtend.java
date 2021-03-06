package threads;

public class MyThreadExtend extends Thread{
	Thread t;
	MyThreadExtend(){
		super("Demo Thread");
		System.out.println("Inside : "+ this.getName());
		this.start();
	}
	
	public void run(){
		try{
			for(int i=5;i>0;i--){
				System.out.println("Child Thread : " + i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e){
			System.out.println("Child thread was interrupted");
		}
	}
	

	public static void main(String[] args) throws InterruptedException{
		new MyThread();
		System.out.println("Entering main Thread");
		//try{
			for(int i=5;i>0;i--){
				System.out.println("Inside Main Thread : "+ i);
				Thread.sleep(1000);
			}
		/*}catch(InterruptedException ie){
			System.out.println("Main Thread was interrupted");
		}*/
		

	}

}
