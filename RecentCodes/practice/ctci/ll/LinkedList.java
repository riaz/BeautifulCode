package practice.ctci.ll;

import java.util.HashSet;
import java.util.Set;

class t_Node{
	private int data;
	private t_Node next = null;
	
	t_Node(){
		this.data = 0;
	}
	
	t_Node(int data){
		this.data = data;
	}
	
	void addToTail(int data){
		t_Node node = new t_Node(data);
		
		//irrespective of on which nodewell call addToTail
		//always add to the tail
		t_Node x = this;
		
		while(x.next!= null)
			x = x.next;
		
		x.next = node;		
	}
	
	t_Node deleteNode(t_Node head,int data){
		t_Node t  = head; //must be the root
		
		if(t.data == data){
			return head.next;
		}
		else{
			while(t.next.data != data){
				t = t.next;
			}
			t.next = t.next.next;
			return head;
		}		
	}
	
	void display(){
		t_Node t = this;
		while(t!= null){
			System.out.print(t.data + " ,");
			t = t.next;
		}
		System.out.println();
	}
	
	void removeDuplicates(){
		HashSet s = new HashSet();		
		
		t_Node t = this;	
		
		while(t!= null){
			if(s.contains(t.data)){
				t_Node x = t;
				t.data = x.data;
				t.next = x.next;
			}	
			else{
				s.add(t.data);
				t = t.next;
			}
		}		
	}
	
	
}
public class LinkedList {
	
	public static void main(String[] args){
		t_Node root = new t_Node(10);
		
		root.addToTail(20);
		root.addToTail(30);
		root.addToTail(40);
		root.addToTail(50);
		
		root.display();
		
		root = root.deleteNode(root, 10);
		
		root.display();
		
		root = root.deleteNode(root, 40);
		
		root.display();
		
	}
}
