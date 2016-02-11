package threads.prodcon;

class Q2{
	int n;
	boolean valueSet = false;
	public synchronized void set(int n){
		while(valueSet){
			try{
				wait();
			}catch(InterruptedException ie){
				System.out.println("Consumer was interrupted");
			}
		}
		this.n = n;
		System.out.println("Set : " + n);
		valueSet = true;
		notify();		
	}
	
	public synchronized int get(){
		while(!valueSet){
			try{
				wait();
			}catch(InterruptedException ie){
				System.out.println("Consumer was interrupted");
			}
		}
		System.out.println("Get : " + n);
		valueSet = false;
		notify();
		
		return this.n;
	}
}

class Producer2 implements Runnable{
	Q2 q;
	
	Producer2(Q2 q){
		this.q = q;
		new Thread(this,"Producer").start();
	}
	
	public void run(){
		int i=0;
		while(true){
			q.set(i++);
		}
	}
}

class Consumer2 implements Runnable{
	Q2 q;	
	Consumer2(Q2 q){
		this.q  = q;
		new Thread(this,"Consumer").start();
	}
	
	public void run(){
		while(true){
			q.get();
		}
	}
}


public class SynchronizedDemo {
	
	public static void main(String[] args){
		Q2 q = new Q2();
		Producer2 p = new Producer2(q);
		Consumer2 r = new Consumer2(q);		
	}
}	
