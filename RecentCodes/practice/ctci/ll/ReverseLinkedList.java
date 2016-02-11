package practice.ctci.ll;

import java.util.HashSet;

class n_Node{
	int data;
	n_Node next = null;
	
	n_Node(int data){
		this.data = data;
	}
	
	public void setNext(n_Node next){
		this.next = next;
	}
	
	public n_Node getNext(){
		return this.next;
	}	
	
	public n_Node getNode(int data){
		n_Node node= this;
		if(node == null) return null;
		while(node != null){
			if(node.data == data)
				return node;
			else
				node = node.next;
		}
		return null;
	}
	
	public void addNode(int data){
		n_Node node = new n_Node(data);
		
		n_Node head = this;
		while(head.next != null)
			head = head.next;
		
		head.next = node;
	}
	
	
	public int getMergeNode(n_Node y){
		HashSet s = new HashSet();
		int ret = -1; //if no merge , returns -1
		
		n_Node head = this;
		while(head != null){
			int hash = head.hashCode();
			if(!s.contains(hash))
				s.add(hash);
			head = head.next;
		}
		
		head = y;
		while(head != null){
			int hash = head.hashCode();
			if(s.contains(hash)){
				ret = head.data;
				break;
			}
			head = head.next;
		}	
		
		return ret;
	}	
	
	public boolean removeNode(n_Node node){
//		n_Node node = this;
//		
//		while(node.data!=data)
//			node = node.next;
//		
//		node = node.next;
//		return this;
		
		if(node == null || node.next == null)
			return false;
		else{
			n_Node x = node.next;
			node.data = x.data;
			node.next = x.next;
			return true;
		}
	}
	
	void removeDuplicates(){
		HashSet s = new HashSet();		
		
		n_Node t = this;		
		while(t!= null){
			if(t.next != null && s.contains(t.next.data)&& t.next.next == null)
				t.next = null;				
			else if(s.contains(t.data)){
				removeNode(t);
			}	
			else{
				s.add(t.data);
				t = t.next;
			}
		}		
	}	
	
	public void display(){
		n_Node head = this;
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public n_Node reverseList(){
		n_Node head = this;
		
		n_Node node = head.next;
		
		head.next = null;
				
		while(node != null){
			n_Node t = node.next;
			node.next = head;
			head = node;
			node = t;
		}			
		return head;		
	}
}

public class ReverseLinkedList {
	
	public static void main(String[] args){
			n_Node head = new n_Node(10);
			
			head.addNode(20);
			head.addNode(30);
			head.addNode(40);
			head.addNode(50);
			
			head.display();
			
			head = head.reverseList();
			head.display();			
			
	}
}
