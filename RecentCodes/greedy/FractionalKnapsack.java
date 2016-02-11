package greedy;

public class FractionalKnapsack {

	//fractional knapsack
	//given a weight output the max-value that can be obtained,
	//when we can take a fraction of stuff.
	
	public int fractionalKnapsack(int[] vbw,int[] w,int W){
		int load = 0;
		int res=0;
		int i=0;
		while(i<vbw.length && load <= W){
			if( w[i] < W-load ){
				load+= w[i];
				res += vbw[i]*w[i];
				i++;
			}
			else{
				res += (int)((vbw[i]*w[i])*((float)(W-load)/(float)w[i]));
				break;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] v = { 50, 140, 60, 60};
		int[] w = {  5,  20, 10, 12};
		
		//getting an array that has the v/w in decreasing order
		
		int[] vbw =  new int[v.length];
		
		for(int i=0;i<v.length;i++)
			vbw[i] = v[i]/w[i];
		
		for(int i=0;i<vbw.length-1;i++){
			for(int j=i;j<vbw.length;j++){
				if(vbw[i] < vbw[j]){//swap
					vbw[i] = vbw[i] + vbw[j];
					vbw[j] = vbw[i] - vbw[j];
					vbw[i] = vbw[i] - vbw[j];					
				}
			}
		}
		
		int cap = 30; //this is the weight capacity of the knapsack
		
		System.out.println("Total value given the capacity " + new FractionalKnapsack().fractionalKnapsack(vbw, w, cap) );

	}

}
