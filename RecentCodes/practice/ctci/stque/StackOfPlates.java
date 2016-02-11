package practice.ctci.stque;

import practice.ctci.stque.StackMin.Node;

public class StackOfPlates {
	Node[] bins;
	int[] sizes;
	int binSize;
	int currBin;
	int currBinSize;
	
	//we implement a array of nodes
	StackOfPlates(int size,int binSize){
		bins = new Node[size];
		for(int i=0;i<bins.length;i++)
			bins[i] = null;
		
		for(int i=0;i<bins.length;i++)
			sizes[i] = 0;				
		
		this.binSize = binSize;
		this.currBin = 0;
		this.currBinSize = 0;
	}
	
	public void push(int data){		
		if((currBin == binSize-1) && (currBinSize == binSize-1))
		{
			System.out.println("All the bins are full");
			System.out.println("Increase the bin size");
		}
		else{
			if(currBinSize == binSize && currBin < binSize-1)
				currBin = currBin+1;
			
				
		}
	}
	
	public int  pop(){
		if(bins[0] == null) {
			System.out.println("Stack is empty");
			return -1; //stack operation is not possible
		}
		else{
			Node node = bins[0];
			int data = node.data;
			node = node.next;
			setup(0);   //to adjust the bins , enabling maximum occupancy
			return data;
		}		
	}
	
	public void setup(int index){
		while(index < binSize && sizes[index+1] > 0){
			//we do a chain shifting upto the bin that has sizes[index] == 0 or upto index == binSize
			while(index+1 < binSize && sizes[index] != binSize && sizes[index+1] > 0){
				Node x = bins[index];
				while(x.next!=null)
					x = x.next;
				
				Node y = bins[index+1];
				Node z = y.next;
				bins[index+1]= z;
				
				y.next = null;
				x.next = y;
			}
			index = index+1;				
		}
	}
	
	
	public int pop(int index){
		if(bins[index]==null)
			return -1; //cannot pop indicator
		
		Node node = bins[index];
		int data = node.data;
		node = node.next;
		sizes[index]--;			
		setup(index);	
		return data;				
	}
	
	
	class Node{
		int data;
		Node next=null;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static void main(String[] args) {
	
	}

}
