package practice;

import java.util.Arrays;

public class BinerySearch {
	
	public int search(int[] a,int x,int low,int high){
		int mid = low + (high-low)/2;
		if(low == high && a[mid] != x)
			return -1;
		
		if(a[mid] == x) 
			return mid;
		else if(x > a[mid] ){
			return search(a,x,mid+1,high);
		}
		else if(x < a[mid])
			return search(a,x,low,mid);
		return -1;
	}
	
	
	public static void main(String[] args){
		int a[] = {4,3,1,2,4,5,8,9,7,0,1,5,3,2};
		
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		//search 0 , 9 and 4
		
		System.out.println(new BinerySearch().search(a,0,0,a.length-1));
		System.out.println(new BinerySearch().search(a,9,0,a.length-1));
		System.out.println(new BinerySearch().search(a,4,0,a.length-1));
		System.out.println(new BinerySearch().search(a,6,0,a.length-1));
			
	}	
}
