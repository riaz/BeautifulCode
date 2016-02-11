package practice.ctci.ll;

class Counter{
	static int value=0;
	static int res = 0;
}
public class KthLastNoBuffer {

	n_Node getKth(n_Node head,int k,int value){
		boolean done = false;
		if(head == null){
			Counter.value++;
			return null;
		}
		else{
			getKth(head.next,k,Counter.value);
			
//			System.out.println(head.data); //must be 1,2,10,5,8,5,3
			
			if(Counter.value == k){
				Counter.res = head.data;
				return head;
			}
			Counter.value++;
		}	
		return null;
	}
	
	//done using return 
	public static void main(String[] args) {
		n_Node root = new n_Node(3);
		
		root.addNode(5);
		root.addNode(8);
		root.addNode(5);
		root.addNode(10);
		root.addNode(2);
		root.addNode(1);
		
		new KthLastNoBuffer().getKth(root,2,Counter.value);
		System.out.println(Counter.res);
		

	}

}
