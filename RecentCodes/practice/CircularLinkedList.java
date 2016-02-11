package practice;

class CLL{
	private DLink head;
	private DLink tail;
	
	private int size;
	
	CLL(){
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
			head.setLeftLink(tail);			
			tail.setRightLink(head);
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
			tail.setRightLink(head);			
			head.setLeftLink(tail);
	
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
public class CircularLinkedList {
	public static void main(String[] args){
		CLL dlist = new CLL();
				
		dlist.insertRight(10);
		dlist.insertLeft(30);
		dlist.insertLeft(20);
		dlist.insertRight(50);
		dlist.insertLeft(70);
		
		//dlist.display(DIR.RIGHT);
		System.out.println("Hello");

	}
}
