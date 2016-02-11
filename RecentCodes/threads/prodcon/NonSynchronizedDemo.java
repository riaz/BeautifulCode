package threads.prodcon;

class Q1{
	int n;
	
	public synchronized void set(int n){
		this.n = n;
		System.out.println("Set : " + n);
	}
	
	public synchronized int get(){
		System.out.println("Get : " + n);

		return this.n;
	}
}

class Producer1 implements Runnable{
	Q1 q;
	
	Producer1(Q1 q){
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

class Consumer1 implements Runnable{
	Q1 q;	
	Consumer1(Q1 q){
		this.q  = q;
		new Thread(this,"Consumer").start();
	}
	
	public void run(){
		while(true){
			q.get();
		}
	}
}


public class NonSynchronizedDemo {
	
	public static void main(String[] args){
		Q1 q = new Q1();
		Producer1 p = new Producer1(q);
		Consumer1 r = new Consumer1(q);		
	}
}	
