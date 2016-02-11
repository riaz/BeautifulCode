package practice.ctci.ll;

public class Partition {
	
	public n_Node partition(n_Node head ,int k){
		//we maintain 2 arrays to do a stable partitioning
		//we may use a shortcut for a non-stable partitioning
		
		//we now declare the head and tail of the two linkedlist that we maintain
		n_Node beforeHead = null;
		n_Node beforeTail = null;
		n_Node afterHead  = null;
		n_Node afterTail  = null;
		
		n_Node node = head;
		
		while(node!=null){
			n_Node next = node.next;
			node.next = null;
			
			if(node.data < k){ //we place in the before LinkedList
					//we can have two cases when the beforeHand is null
					
					//we then set beforeHead to the new value and beforeHead == beforeTail
					if(beforeHead == null){
						beforeHead = node;						
						beforeTail = beforeHead;
					}
					else{ //we just add to the beforeTail otherwise
						beforeTail.next = node;
						beforeTail = node;
					}					
			}
			else{ //we place in the after linked list
				//we can have two cases when the afterHand is null
				
				//we then set beforeHead to the new value and afterHead == afterTail
				if(afterHead == null){
					afterHead = node;						
					afterTail = afterHead;
				}
				else{ //we just add to the afterTail otherwise
					afterTail.next = node;
					afterTail = node;
				}
			}
			node = next;
		}
		//we now have partitioned the linkedlist into before and after
		//we now merge them and return 
		
		if(beforeTail==null){
			return afterHead;
		}
		
		else{
			beforeTail.next = afterHead;
			return beforeHead;
		}
		
		
	}
	
	public static void main(String[] args){
		n_Node root = new n_Node(3);
		
		root.addNode(5);
		root.addNode(8);
		root.addNode(5);
		root.addNode(10);
		root.addNode(2);
		root.addNode(1);
		
		root = new Partition().partition(root, 5);
				
		root.display();

	}
}
