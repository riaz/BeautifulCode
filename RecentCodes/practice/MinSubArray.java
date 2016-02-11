package practice;

//this program takes an array ,and an integer s
//we need to find a subset of this array whose sum >= s, also
//the size of this array needs to be minimum

public class MinSubArray {
	int[] res;
	int size;
	
	MinSubArray(){
		size = 999999999;
	}

	@Override
	public String toString(){
		String out = "";
		
		for(int i=0;i<size;i++){
				out = out + res[i] + " "; 
		}
		
		return out;
	}
	
	public int[] getMinSubArray(int a[],int cutoff){
		res = new int[a.length];
		int[] aux = new int[a.length];
		
		int start = 0;
		int sum;
		
		while(start!=a.length){
			sum = 0;
			int x = 0;
			for(int s=start; s < a.length && sum <= cutoff ;s++,x++){
				sum += a[s];
				aux[x] = a[s];
			}
						
			if(x < size && sum >= cutoff){
//				for(int i=0;i<x;i++)
//					System.out.print(aux[i]+ " ");
//				System.out.println();
			
				size = x;
				for(int i=0;i<x;i++){
					res[i] = aux[i];
				}			
			}
			start++;
		}
//		System.out.println(size);
		
		for(int i=0;i<size;i++){
			System.out.print(res[i] + " ");
		}
		System.out.println();

		
		return res;
	}
	
	
	public static void main(String[] args){
		
		int a[] = {2,3,1,2,4,3};
		int cutoff = 7;
		
		
		//note: the values will be contiguous
		
		//cutt-off will be when the subset reache cutt-off
		
		new MinSubArray().getMinSubArray(a, cutoff);
		//System.out.println(new MinSubArray());
		

	}
}
