package threads;

public class RunnableDemo implements Runnable {

	public static void main(String[] args){
		(new Thread(new RunnableDemo())).start();
	}

	@Override
	public void run() {
		System.out.println("Hello from a thread");		
	}
}
