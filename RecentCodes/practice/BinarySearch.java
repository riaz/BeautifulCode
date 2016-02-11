package practice;

public class BinarySearch {

	public int search(int a[],int n,int low,int high){
		int mid = low  + (high-low)/2;
		if(low == high && a[mid] != n){
			System.out.println("Not Found");
			return -1;
		}else if(a[mid] == n){		
			System.out.println("Found at : "+ mid);
			return mid;			
		}else{
			if(n > a[mid])
				return search(a,n,mid+1,high);
			else
				return search(a,n,low,mid-1);					
		}
			
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		new BinarySearch().search(a,2, 0, a.length-1);
	}
}
