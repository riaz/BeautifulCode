package practice.ctci.trees;

import java.util.Stack;

class Node{
	int data;
	Node left,right;
	
	Node(int data){
		this.data = data;
		left  = right = null;
	}
}

public class IterBST {
	Node root;
	/*
	 *  Program to perform an in-order traversal of a BST ,iteratively
	 * */
	
	//achieved using a stack
	void inorder(){
		if(root == null) return;
		
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		
		//first node to be visited will be the left most one
		while(node!=null){
			stack.push(node);
			node = node.left;
		}
		
		while(!stack.isEmpty()){
			Node n = stack.pop();
			System.out.println(n.data);
			
			if(n.right != null){
				n = n.right;
				stack.push(n);
				while(n.left!=null){
					stack.push(n.left);
					n = n.left;
				}					
			}
		}
	}
	
	public static void main(String[] args) {
		IterBST bst = new IterBST();
		bst.root = new Node(1);
		bst.root.left = new Node(2);
		bst.root.right = new Node(3);
		bst.root.left.left = new Node(4);
		bst.root.left.right = new Node(5);
		bst.inorder();			
	}
}
