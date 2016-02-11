package practice;

enum DIR { RIGHT,LEFT};

class Link{
	private int data;
	private Link next;
	
	Link(){
		this.data = 0;
		this.next = null;
	}
	
	Link(int data,Link next){
		this.data = data;
		this.next = next;
	}
	
	public void setLink(Link next){
		this.next = next;
	}
	
	public Link getLink(){
		return this.next;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}	
}

class DLink{
	private int data;
	private DLink left;
	private DLink right;
	
	
	DLink(){
		this.data = 0;
		this.left = null;
		this.right = null;		
	}
	
	DLink(int data,DLink left,DLink right){
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	public void setRightLink(DLink right){
		this.right = right;
	}
	
	public void setLeftLink(DLink left){
		this.left = left;
	}
	
	public DLink getRightLink(){
		return this.right;
	}
	
	public DLink getLeftLink(){
		return this.left;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}	
}

class LL{
	private Link head;
	private  int size;
	
	LL(){
		head = null;
		size = 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public void addLink(int data){
		Link newLink = new Link(data,null);
		if(head == null){
			head = newLink;
		}
		else{
			Link last = head;
			while(last.getLink()!=null)
				last = last.getLink();			
			last.setLink(newLink);
		}
		this.size++;
	}
	
	public void display(){
		if(head == null){
			System.out.println("The list is empty");
		}
		else{
			Link last = head;
			do{
				System.out.print(last.getData()+ " ,");
				last = last.getLink();
			}while(last != null);
			System.out.println();
		}
	}
	
	public int remove(int data){
		if(head == null){
			return -1;
		}
		else{
			Link last = head;			
			//first , last and intermediate cases
			this.size--;
			if(last.getData() == data){
				head = last.getLink();
				return data;
			}else{
				while(last.getLink() != null){
					if(last.getLink().getData() == data){
						Link newLink = last.getLink().getLink();
						last.setLink(newLink);
						return data;
					}
					else
						last = last.getLink();
				}
				return -1;
			}			
		}
	}
}

class DLL{
	private DLink head;
	private DLink tail;
	
	private int size;
	
	DLL(){
		this.head = this.tail = null;
		this.size = 0;
	}
	
	public int size(){
		return this.size;
	}
		
	public void insertLeft(int data){
		DLink newLink = new DLink(data,null,null);
		if(head == null){			
			head = newLink;
			tail = newLink;
		}
		else{
			DLink last = head;
			//we navigate only the left links until null
			while(last.getLeftLink()!=null){
				last = last.getLeftLink();
			}
			
			newLink.setRightLink(last);
			last.setLeftLink(newLink);			
			head = newLink;			
		}
		size++;
	}
	
	public void insertRight(int data){
		DLink newLink = new DLink(data,null,null);
		if(head == null){			
			head = newLink;		
			tail = newLink;
		}
		else{
			DLink last = tail;
			//we navigate only the left links until null
			while(last.getRightLink()!=null){
				last = last.getRightLink();
			}
			newLink.setLeftLink(last);
			last.setRightLink(newLink);
			tail = newLink;
		}
		size++;
	}
	
	public void display(DIR dir){		
		if(head == null)			
			System.out.println("List is empty");		
		else{
			if(dir == DIR.RIGHT){
				DLink last = head;
				//we navigate only the left links until null
				while(last!=null){
					System.out.print(last.getData() + " ,");
					last = last.getRightLink();
				}
				System.out.println();
			}
			else{
				DLink last = tail;
				//we navigate only the left links until null
				while(last!=null){
					System.out.print(last.getData() + " ,");
					last = last.getLeftLink();
				}
				System.out.println();
			}			
		}
	}	
}

public class LinkedList{
	public static void main(String[] args){
		LL list = new LL();
		DLL dlist = new DLL();
	
		list.addLink(10);
		list.addLink(20);
		list.addLink(30);
		
		dlist.insertRight(10);
		dlist.insertLeft(30);
		dlist.insertLeft(20);
		dlist.insertRight(50);
		dlist.insertLeft(70);
				
		list.remove(20);
		list.remove(10);
		
		list.display();
		
		//expected: 70 20 30 10 50
		System.out.println(dlist.size());
		
		System.out.println("Right List");
		dlist.display(DIR.RIGHT);
		
		System.out.println("Left List");
		dlist.display(DIR.LEFT);	
	}
}