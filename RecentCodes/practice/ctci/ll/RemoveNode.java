package practice.ctci.ll;

public class RemoveNode {

	public static void main(String[] args) {
		n_Node head = new n_Node(10);
		
		head.addNode(20);
		head.addNode(30);
		head.addNode(40);
		head.addNode(50);
		
		head.display();
		
		head = head.reverseList();
		head.display();
		
		n_Node node = head.getNode(30);
		head.removeNode(node);
		head.display();			

	}

}
