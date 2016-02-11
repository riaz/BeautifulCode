package practice.ctci.trees;

import java.util.Vector;

class BstAdt{
	private TNode root;
	private int nodeCount;
	
	BstAdt(){
		root = null;
	}
	
	public TNode getRoot(){
		return this.root;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public TNode insertItem(TNode tn,int item){
		if(tn == null){
			tn = new TNode(item,null,null);
			if(root == null)
				root = tn;
			return tn;
		}
		else{
			if(item > tn.getData()){
				TNode node = insertItem(tn.getRightChild(),item);
				tn.setRightChild(node);
				return tn;
			}else{
				TNode node =  insertItem(tn.getLeftChild(),item);
				tn.setLeftChild(node);
				return tn;
				//System.out.println("He");				
			}
		}
	}
	
	public boolean isBST(Vector<Integer> lst){
		for(int i=0;i<lst.size()-1;i++){
			if(lst.get(i) > lst.get(i+1))
				return false;
		}
		return true;
	}
	
	public boolean search(TNode tn,int item){
		if(tn == null) return false;
		
		if(item == tn.getData()){
			return true;
		}else{
			
			if(item > tn.getData())
				search(tn.getRightChild(),item);			
			else
				search(tn.getLeftChild(),item);
		}	
		return false;
	}
	
	public void inOrder(TNode tn,Vector<Integer> lst){
		if(tn == null) return;
		inOrder(tn.getLeftChild(),lst);
		System.out.print(tn.getData()+ " ,");
		lst.add(tn.getData());
		inOrder(tn.getRightChild(),lst);
		
	}
	
	public void preOrder(TNode tn){
		if(tn == null) return;
		System.out.print(tn.getData()+ " ,");
		preOrder(tn.getLeftChild());
		preOrder(tn.getRightChild());		
	}
	
	public void postOrder(TNode tn){
		if(tn == null) return;
		postOrder(tn.getLeftChild());
		postOrder(tn.getRightChild());
		System.out.print(tn.getData()+ " ,");
		
	}
	
	
}

class TNode{
	
	int data;
	TNode left;
	TNode right;
	
	public TNode(){
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	
	public TNode(int data,TNode left,TNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setLeftChild(TNode left)
	{
		this.left = left;
	}
	
	public void setRightChild(TNode right)
	{
		this.right = right;
	}
	
	public TNode  getLeftChild()
	{
		return this.left;
	}
	
	public TNode getRightChild()
	{
		return this.right;
	}	
}

public class CheckBalanced {
	
	public boolean isBalanced(TNode root){
		if (root == null) return true;
		return true && Math.abs(getHeight(root.left) - getHeight(root.right)) <=1;
	}
	
	public int getHeight(TNode root){
		if (root == null) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void main(String[] args) {
		BstAdt bst = new BstAdt();
		
		bst.insertItem(bst.getRoot(),4);
		bst.insertItem(bst.getRoot(),2);
		bst.insertItem(bst.getRoot(),5);
//		bst.insertItem(bst.getRoot(),4);
//		bst.insertItem(bst.getRoot(),5);
//		bst.insertItem(bst.getRoot(),6);
//		bst.insertItem(bst.getRoot(),7);
//		bst.insertItem(bst.getRoot(),8);
//		bst.insertItem(bst.getRoot(),9);
		
		//expected: 3
		System.out.println("The height of the tree is: " + new CheckBalanced().isBalanced(bst.getRoot()));	
		
	}

}
