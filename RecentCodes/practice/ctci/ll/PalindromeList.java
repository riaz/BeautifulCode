package practice.ctci.ll;

/*
 * Program to check if a linked list is palindrome or not
 *
 * */

enum DIR {LEFT,RIGHT};

class p_Node{
	int data;
	p_Node left = null;
	p_Node right = null;
	
	p_Node(int data){
		this.data = data; 
	}
	
	public void appendLeft(int data){
		p_Node node = new p_Node(data);
		
		p_Node t = this;
		
		while(t.left!=null){
			t = t.left; 
		}		
		t.left = node;	
		node.right = t;
	}
	
	public void appendRight(int data){
		p_Node node = new p_Node(data);
		
		p_Node t = this;
		
		while(t.right!=null){
			t = t.right; 
		}

		t.right = node;		
		node.left = t;
	}
	
	/* note only works in the left scenario */
	public void deleteThisNode(int data){
		p_Node node = getNode(data);
		node = node.left; 
	}
	
	public p_Node getNode(int data){
		p_Node t = this;
		while(t!= null){
			if(t.data == data)
				break;
			t = t.left;
		}
		return t;
	}
	
	
	
	public void display(DIR dir){
		p_Node t = this;
		
		if(dir == DIR.LEFT){ //go for the left nodes
			while(t!= null){
				System.out.print(t.data + " ,");
				t = t.left;
			}
			System.out.println();
		}
		else{ //go for the right nodes
			while(t!= null){
				System.out.print(t.data + " ,");
				t = t.right;
			}
			System.out.println();
		}
	}
	
	public String toString(DIR dir){
		p_Node t = this;
		String res = "";
		if(dir == DIR.LEFT){ //go for the left nodes
			while(t!= null){
				res +=  (t.data);
				t = t.left;
			}			
		}
		else{ //go for the right nodes
			while(t!= null){
				res +=  (t.data);
				t = t.right;
			}			
		}
		
		return res;
	}	
	
}
public class PalindromeList {

	public static void main(String[] args) {
		p_Node root = new p_Node(1);
		
		root.appendLeft(2);
		root.appendLeft(3);		
		root.appendLeft(2);
		root.appendLeft(1);
		
		root.display(DIR.LEFT);
		root.display(DIR.RIGHT);
		
		root.deleteThisNode(3);
		
		root.display(DIR.LEFT);
		
		//System.out.println(root.toString(DIR.LEFT));
		//System.out.println(root.toString(DIR.RIGHT));
	}

}
