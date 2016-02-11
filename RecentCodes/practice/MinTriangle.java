package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinTriangle {

	public int getMinimumPath(List<List<Integer>> x){
		List<Integer> prevRow = x.get(0);  //has 1 element
		
		for(int i=1;i<x.size();i++){
			List<Integer> currRow = x.get(i);
			currRow.set(0, currRow.get(0) + prevRow.get(0));
			for(int j=1;j<currRow.size()-1;j++){
				currRow.set(j, Math.min(currRow.get(j) + prevRow.get(j), currRow.get(j) + prevRow.get(j-1)));
			}
			int val = currRow.size()-1;
			currRow.set(val, currRow.get(val) + prevRow.get(val-1));
			prevRow = currRow;
		}
		
		return Collections.min(x.get(x.size()-1));
	}
	
	public static void main(String[] args) {
		List<List<Integer>> lst = Arrays.asList(
					Arrays.asList(2),
					Arrays.asList(3,4),
					Arrays.asList(6,5,7),
					Arrays.asList(4,1,8,3));
		
		//Displaying the resultant Triangle
		for(List<Integer> x  : lst){
			for(Integer y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}		
		
		//We need to find the most efficient path to reach the bottom		
		System.out.println("Minumum Path is : " + new MinTriangle().getMinimumPath(lst));				

	}

}
