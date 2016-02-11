package practice.ctci.trees;

import java.util.Vector;

public class ValidBST {
	Vector<Integer> v;
	ValidBST(int len){
		v  = new Vector();
	}
	
	public void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		v.add(root.val);
		inorder(root.right);		
		
	}
	
	public boolean isBST(){
		for(int i=0;i<v.size()-1;i++){
			if(v.elementAt(i) > v.elementAt(i+1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		//Program to check if a BST is valid
		int[] a = {1,2,3,4,5,6,7};
		
		TreeNode root = new MinimalTree().sortedArrayToBST(a);
		
		ValidBST bst = new ValidBST(a.length);
		
		System.out.println(bst.isBST());
		
	}

}
