package practice;

//this program is used to find the peak element in a linear array
//a peek elememt , is the element whos neighbours are smaller than it.

public class PeakElement {
	
	public int getPeek(int[] a){
		
		//there are two edge cases
		int maxIdx = 0;
		int len = a.length;
		assert len > 0;
		
		if(len > 1){
			if(a[0] > a[1])
				maxIdx =  0;
		
			for(int i=1;i<len;i++){
				if(a[i] > a[i-1]){
					if(i+1 < len && a[i] > a[i+1])
						maxIdx = a[i] > a[maxIdx] ? i : maxIdx;
					if(i+1 == len)
						maxIdx = a[i] > a[maxIdx] ? i : maxIdx;
				}
			}
		}
		
		return maxIdx;			
		
	}
	
	public static void main(String[] args){
		int a[] = {5,2,3,1,4};
		System.out.println(new PeakElement().getPeek(a));
	}
}
