package practice;

import java.util.Arrays;

public class RotateArray {
	
	//O(n) time and O(n) space
	public void rotateNaive(int[] arr,int k){
		//Attempt to use System.arraycopy
		k = k % arr.length;
		int len = arr.length;
		
		int copy[] = new int[arr.length*2];
		
		System.arraycopy(arr, 0, copy, arr.length, arr.length);
		System.arraycopy(arr, 0, copy, 0, arr.length);
		
				
		for(int i=arr.length-k,j=0;j<arr.length;i++,j++)
			arr[j] = copy[i];	
		
	}
	
	//O(n*k) time and O(1) space
	public void rotateBubble(int[] arr, int order) {
		if (arr == null || order < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
	 
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
	}
	
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
	
	//O(n) time and O(1) space
		public void rotateEfficient(int[] arr, int order) {
			order = order % arr.length;
			//algo
			//split the arr into 2 halves split at order from back
			//reverse both the halves , seperately
			//reverse the whole array
			if (arr == null || order < 0) {
				throw new IllegalArgumentException("Illegal argument!");
			}
		 
			//length of first part
			int a = arr.length - order; 
		 
			reverse(arr, 0, a-1);
			reverse(arr, a, arr.length-1);
			reverse(arr, 0, arr.length-1);
		}
	
	
	
	
	public static void main(String[] args){
		int a[] = {4,2,3,1,7,8,9,10,11,6,5};
		
		int[] tmp = Arrays.copyOf(a, a.length);
		new RotateArray().rotateNaive(tmp,2);
		
		for(int i=0;i<tmp.length;i++)
			System.out.print(tmp[i] + " ,");
		System.out.println();
		
		tmp = Arrays.copyOf(a, a.length);
		new RotateArray().rotateBubble(tmp,2);
		
		for(int i=0;i<tmp.length;i++)
			System.out.print(tmp[i] + " ,");
		System.out.println();
		
		tmp = Arrays.copyOf(a, a.length);
		new RotateArray().rotateEfficient(tmp,2);
		
		for(int i=0;i<tmp.length;i++)
			System.out.print(tmp[i] + " ,");
		System.out.println();
		
	}
}
