package threads;


class CallmeFixed{
	synchronized void call(String msg){
		System.out.print("[" + msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class CallerFixed implements Runnable{
	String msg;
	CallmeFixed target;
	Thread t;
	
	CallerFixed(CallmeFixed target,String msg){
		this.msg = msg;
		this.target = target;
		t = new Thread(this);
		t.start();
	}
	
	public void run(){
		target.call(msg);
	}
}

public class SynchFixed {
	public static void main(String[]args){
		CallmeFixed target = new CallmeFixed();
		
		CallerFixed ob1 = new CallerFixed(target, "Hello");
		CallerFixed ob2 = new CallerFixed(target, "Synchronized");
		CallerFixed ob3 = new CallerFixed(target, "World");
		
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();			
		}catch(InterruptedException ie){
			System.out.println("Interrupted");
		}
		
	}	
}
