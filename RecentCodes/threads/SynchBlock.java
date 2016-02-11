package threads;

/* used synchronized block for synchronization*/
class CallmeBlock{
	void call(String msg){
		System.out.print("[" + msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class CallerBlock implements Runnable{
	String msg;
	CallmeBlock target;
	Thread t;
	
	CallerBlock(CallmeBlock target,String msg){
		this.msg = msg;
		this.target = target;
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		synchronized(target){ //where is the object that needs to be synchronized , which is not designed for multi-threading
			target.call(msg);
		}
	}
}

public class SynchBlock {
	public static void main(String[]args){
		CallmeBlock target = new CallmeBlock();
		
		CallerBlock ob1 = new CallerBlock(target, "Hello");
		CallerBlock ob2 = new CallerBlock(target, "Synchronized");
		CallerBlock ob3 = new CallerBlock(target, "World");
		
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();			
		}catch(InterruptedException ie){
			System.out.println("Interrupted");
		}
		
	}	
}
