package practice;

import java.io.PrintStream;
import java.util.Vector;

class Std{
	static PrintStream out;
	public static void println(String args){		
		out.print(args);
	}
}

class TreeNode{
	
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int data,TreeNode left,TreeNode right){
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
	
	public void setLeftChild(TreeNode left)
	{
		this.left = left;
	}
	
	public void setRightChild(TreeNode right)
	{
		this.right = right;
	}
	
	public TreeNode  getLeftChild()
	{
		return this.left;
	}
	
	public TreeNode getRightChild()
	{
		return this.right;
	}	
}

class BstAdt{
	private TreeNode root;
	private int nodeCount;
	
	BstAdt(){
		root = null;
	}
	
	public TreeNode getRoot(){
		return this.root;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public TreeNode insertItem(TreeNode tn,int item){
		if(tn == null){
			tn = new TreeNode(item,null,null);
			if(root == null)
				root = tn;
			return tn;
		}
		else{
			if(item > tn.getData()){
				TreeNode node = insertItem(tn.getRightChild(),item);
				tn.setRightChild(node);
				return tn;
			}else{
				TreeNode node =  insertItem(tn.getLeftChild(),item);
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
	
	public boolean search(TreeNode tn,int item){
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
	
	public void inOrder(TreeNode tn,Vector<Integer> lst){
		if(tn == null) return;
		inOrder(tn.getLeftChild(),lst);
		System.out.print(tn.getData()+ " ,");
		lst.add(tn.getData());
		inOrder(tn.getRightChild(),lst);
		
	}
	
	public void preOrder(TreeNode tn){
		if(tn == null) return;
		System.out.print(tn.getData()+ " ,");
		preOrder(tn.getLeftChild());
		preOrder(tn.getRightChild());		
	}
	
	public void postOrder(TreeNode tn){
		if(tn == null) return;
		postOrder(tn.getLeftChild());
		postOrder(tn.getRightChild());
		System.out.print(tn.getData()+ " ,");
		
	}
	
	
}

public class BST {
	public static void main(String args[]){
		BstAdt bst = new BstAdt();
		
		bst.insertItem(bst.getRoot(),10);
		bst.insertItem(bst.getRoot(),5);
		bst.insertItem(bst.getRoot(),30);
		bst.insertItem(bst.getRoot(),80);
		bst.insertItem(bst.getRoot(),20);
		bst.insertItem(bst.getRoot(),70);
		bst.insertItem(bst.getRoot(),15);
		bst.insertItem(bst.getRoot(),10);
		bst.insertItem(bst.getRoot(),30);
		
		Vector<Integer> isBst = new Vector<Integer>(); 
		bst.inOrder(bst.getRoot(),isBst);   System.out.println();
		bst.preOrder(bst.getRoot());  System.out.println();
		bst.postOrder(bst.getRoot()); System.out.println();
		
		System.out.println("is BST: " + bst.isBST(isBst));
	
		System.out.println(bst.search(bst.getRoot(), 70));
		
	}
}
