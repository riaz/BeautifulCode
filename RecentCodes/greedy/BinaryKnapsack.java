package greedy;

public class BinaryKnapsack {
	//Note: this algorithm doesnt fit into this category i.e greedy algorithms , and is efficiently solved
	//using Dynamic Programming , we write  greedy and dp solution to the client program and check for correctness.
	
	public int getBestValueGreedy(int[] p,int[] s,int W){
		int res = 0;
		int load=0;
		
		for(int i=0;i<p.length;i++)
		{
			if(s[i] < (W-load)){
				res += p[i];
				load +=  s[i];
			}
			else
				break;
		}
		
		return res;
	}
	
	public int getBestValueDynamic(int[] p,int[] s,int W){
		int res=0;
		int best = res;
		
		//arrange p/s in decreasing order and add to the result until load >= W.
		//ans will be 18 in the below example
		return 0;
	}
	
	public static void main(String[] args) {
		
		//price - to be ordered in decreasing order, weights follow
		int[] p = {5, 9, 9,12};
		int[] s = {7,10,10,24};
		
		//sort based on increasing order of price
		for(int i=0;i<p.length-1;i++){
			for(int j=i;j<p.length;j++){
				if(p[i] < p[j]){//swap
					p[i] = p[i] + p[j];
					p[j] = p[i] - p[j];
					p[i] = p[i] - p[j];		
					
					s[i] = s[i] + s[j];
					s[j] = s[i] - s[j];
					s[i] = s[i] - s[j];		
				}
			}
		}
		
		int W = 30;
		
		// Optimal Output: 18
		// 10 10
		
		//Greedy Solution - based on the greedy choice of max value first
		System.out.println(new BinaryKnapsack().getBestValueGreedy(p,s,W));
		
		//Dynamic Programming - gives an optimal solution to 01 knapsack
		System.out.println(new BinaryKnapsack().getBestValueDynamic(p,s,W));				
		
	}

}
