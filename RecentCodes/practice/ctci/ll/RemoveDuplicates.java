package practice.ctci.ll;

/*
 * Program to remove duplicates from a unsorted linkedlist
 * 
 */

public class RemoveDuplicates {
	
	public static void main(String args[]){
		n_Node head = new n_Node(10);
		
		head.addNode(20);
		head.addNode(50);
		head.addNode(30);
		head.addNode(40);
		head.addNode(30);
		head.addNode(50);
		head.addNode(60);
		
		head.display();
		
		head.removeDuplicates();		
		
		head.display();
		
	}
}
