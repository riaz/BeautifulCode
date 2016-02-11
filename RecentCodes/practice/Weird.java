package practice;

import java.util.LinkedList;

class Node{
	protected int data;
	protected Node next;
	
	Node(int data){
		this.data = data;
	}
	
	Node(Node next,int data){
		this.next = next;
		this.data = data;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
}

class WxNode extends Node{
	WxNode(Node next,int data){
		super(next,data);
	}
	
	public WxNode addNode(int data){
		WxNode newNode = new WxNode(null,data);
		this.setNext(newNode);
		return newNode;
	}
	
	public WxNode getNext(){
		return (WxNode)super.getNext();
	}
	
	public void setNext(WxNode next){
		this.next = next;
	}
}

class WxList{
	private WxNode head;
	private int size;
	
	WxList(){
		head = null;
		size = 0;
	}
	
	public void addNode(int data){
		if(head == null){
			WxNode newNode = new WxNode(null,data);			
			head = newNode;
		}
		else{
			WxNode last = head;
			while(last.getNext()!=null)
				last = last.getNext();
			last.addNode(data);		
		}		
		size++;
	}
	
	public void display(){
		WxNode last = head;
		
		if(head == null){
			System.out.println("List is empty");
		}
		else{
			do{
				System.out.print(last.getData()+ " ,");
				last = last.getNext();
			}while(last!=null);
			System.out.println();
		}		
	}
	
	public String toString(){
		WxNode last = head;
		String result = "";
		if(head == null){
			result += "List is empty";
		}
		else{
			do{
				result += last.getData() + " ,";
				last = last.getNext();
			}while(last!=null);			
		}		
		return result;
	}
	
	public Object[] toArray(){
		if(this.size == 0){
			Object[] array = {};
			return array;
		}else{
			Object[] array = new Object[this.size];
			
			WxNode last = head;
			int i=0;
			do{
				array[i++] = last.getData();
				last = last.getNext();
			}while(last!=null);	
			return array;
		}
	}
	
	public void addFirst(int data){
		WxNode newHead = new WxNode(head,data);
		head = newHead;	
		this.setSize(this.size+1);
	}
	
	public void addLast(int data){
		WxNode last = head;
		
		if(head == null){
			WxNode newHead = new WxNode(null,data);
			head = newHead;
		}
		else{
			do{				
				last = last.getNext();
			}while(last.getNext()!=null);
			last.addNode(data);
		}		
		this.setSize(this.size+1);
	}		
	
	
	
	public int  size(){
		return this.size;
	}	
	
	/* This is an internal private method */
	private void setSize(int size){
		this.size = size;
	}
	
	public void clear(){
		head = null;
	}
	
	public boolean contains(int data){
		WxNode last = head;
		
		if(head == null){
			return false;
		}
		else{
			do{				
				if(last.getData() == data)
					return true;
				last = last.getNext();
			}while(last!=null);
		}		
		return false;
	}
	
	public int remove(){
		int data = head.getData(); //this is removed from the list
		head = head.getNext();
		this.setSize(this.size-1);
		return data;
	}
	
	public int removeFirst(){
		int data = head.getData(); //this is removed from the list
		head = head.getNext();
		this.setSize(this.size-1);
		return data;	
	}
	
	public int removeLast(){
		WxNode last = head;		
		if(head == null){
			return -1; //list is empty, couldn't remove
		}
		else{
			do{				
				last = last.getNext();
			}while(last.getNext().getNext()!=null);
			int data = last.getData();
			last.setNext(null);
			this.setSize(this.size-1);
			return data;
		}	
	}
	
	public int getFirst(){
		if(head == null)
			return -1;
		else
			return head.getData();
	}
	
	public int getLast(){
		WxNode last = head;		
		if(head == null){
			return -1; //list is empty, couldn't remove
		}
		else{
			do{				
				last = last.getNext();
			}while(last.getNext()!=null);
			return last.getData();
		}	
	}
	
	public int element(){
		return getFirst();
	}
	
	public boolean addAll(WxList newList){
		boolean changed = false;
		int oldSize = this.size,newSize;
		//reach the tail
		WxNode last = head;		
		if(last != null){
			do{				
				last = last.getNext();
			}while(last.getNext()!=null);			
		}	
		
		for(Object obj  : newList.toArray()){
			if(last == null){
				WxNode newHead = new WxNode(null,(int)obj);
				size++;
				last = newHead;				
			}
			else{				
				last.addNode((int)obj);
				last = last.getNext();
				size++;
			}		
		}
		
		newSize = this.size;
		
		changed = (size != oldSize) ? true: false;
		
		return changed;	
	}
	
	public void push(int data){
		addFirst(data);
	}
	
	public void pop(){
		removeFirst();
	}
	
	
	
	//push,pop,get,indexOf,sort
}

public class Weird {
	public static void main(String[] args){
		
		WxList list = new WxList();
				
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		
		/* WxList implements toString */
		System.out.println(list);
		
		
		/* WxList::toArray*/
		System.out.println("List as Object List");
		for(Object ob: list.toArray()){
			System.out.print(ob +" ");
		}
		System.out.println();
		
		/* WxList add first */
		list.addFirst(50);
		
		/* WxList implements toString */
		System.out.println(list);
		System.out.println("Size : " +list.size()); //display the new size
		
		/* WxList add last */
		list.addLast(90);	
		
		/* WxList implements toString */
		System.out.println(list);
		System.out.println("Size : " +list.size()); //display the new size
		
		/* Checkng contains */
		System.out.println(list.contains(50));
		System.out.println(list.contains(90));
		
		
		/*Trying the remove first function*/
		list.removeFirst();
		System.out.println(list);
		System.out.println("Size : " +list.size()); //display the new size
		
		/*Trying the remove last function*/
		list.removeLast();
		System.out.println(list);
		System.out.println("Size : " +list.size()); //display the new size
		
		
		/*Running getFirst ,getLast and element*/
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.element());
		
		/* Using add All*/
		WxList newList = new WxList();
		newList.addNode(11);
		newList.addNode(22);
		newList.addNode(33);
		newList.addNode(44);
		newList.addNode(55);
		
		list.addAll(newList); //must return true
		System.out.println(list);
		System.out.println("Size : " +list.size()); //display the new size

		/* Checking Stack operations */
		
		System.out.println("Size : " + newList.size()); //display the size of newList
		System.out.println(newList);
		
		newList.pop();
		newList.pop();
		newList.push(11);
		newList.push(22); 
		
		//expected: 22,11,33,44,55 , size: 5
		System.out.println("Size : " + newList.size()); //display the size of newList
		System.out.println(newList);		
	}
}
