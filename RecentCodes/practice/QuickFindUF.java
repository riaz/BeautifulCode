package practice;

public class QuickFindUF {
	static int a[] = new int[5];
	
	
	//O(1)
	public boolean isConnected(int x,int y){
		return a[x] == a[y];
	}
	
	//O(N)
	public void union(int x,int y){
		//we make every a[y] ,to a[x] value
		for(int i=0;i<a.length;i++){
			if(a[i] == a[y]){
				a[y] = a[x];
			}
		}
	}	
	
	public static void main(String[] args) {
		//initializing
		for(int i=0;i<5;i++)
		{
			a[i] = i;
		}
		
		QuickFindUF qf = new QuickFindUF();
		
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
