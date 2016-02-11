package practice;

public class QuickUnionUF {

	int a[];
	int count;
	
	public int count(){
		return count;
	}
	
	//O(N)
	public int find(int num){
		//we use this function to find the parent of num
		while(num!=a[num])
			num = a[num];
		return num;
	}
	
	
	QuickUnionUF(int n){
		a = new int[n];
		for(int i=0;i<n;i++)
			a[i] = i;
	}
	
	//O(N)
	public boolean isConnected(int p,int q){
		return find(p) == find(q);
	}
	
	
	public void union(int p,int q){
		int head_p = find(p);
		int head_q = find(q);
		
		//we set a[q] to be the head of p(head_p)
		if(head_p == head_q) return;
		a[q] = head_p;
		count--;
	}
	
	public static void main(String[] args) {
		QuickUnionUF qf = new QuickUnionUF(5);
		
		System.out.println(qf.isConnected(0, 1));
		System.out.println(qf.isConnected(2, 4));
		System.out.println(qf.isConnected(1, 4));
		
		qf.union(0, 1);
		qf.union(1, 4);
				
		System.out.println(qf.isConnected(0, 1));
		System.out.println(qf.isConnected(1, 4));
		
		System.out.println(qf.isConnected(0, 4));		

	}

}
