package practice.ctci.ll;

public class FindMerge {
	//My putting the hash of the linkedlist object in hashes
	//time taken = O(m+n)
	
	public static void main(String[] args){
		n_Node head = new n_Node(3);
		n_Node head2 = new n_Node(12);
		
		head.addNode(6);
		head.addNode(9);
		head.addNode(15);
		head.addNode(30);
		
		
		head2.addNode(10);
		
		
		head2.getNode(10).setNext(head.getNode(15));   //merge location is 5
		//output from the algorithm should me 15
		
		//equal objects have the same hashcode , and we use a hashSet to find the merge point. 
		//System.out.println(head.hashCode());
		//System.out.println(head2.hashCode());
		
		
		head.display();		
		head2.display();
		
		//get merge location
		
		System.out.println(head.getMergeNode(head2));
				
	}
}
