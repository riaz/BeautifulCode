package practice.ctci.trees;

//public class MinimalTree {
//	Node root = null;
//	
//	MinimalTree(int[]a, int i,int j){
//		generateMinimalTree(a,i,j);
//	}
//	
//	public Node generateMinimalTree(int[] a,int i,int j){
//		//given a is a sorted array
//		if(i>j)
//			return null;
//		
//		int mid = i+ (j-i)/2;
////		System.out.println(a[mid]);
//		if(root == null){
//			root = new Node(a[mid]);
//			root.left =  generateMinimalTree(a,i,mid-1);
//			root.right = generateMinimalTree(a,mid+1,j);
//			return root;
//
//		}
//		else
//		{
//			Node x = new Node(a[mid]);
//			x.left =  generateMinimalTree(a,i,mid-1);
//			x.right = generateMinimalTree(a,mid+1,j);
//			return x;
//
//		}
//	}
//	
//	
//	public void inorder(){
//		System.out.println(root.data);
////		inorder(root);
//	}
//	
//	public void inorder(Node root){
//		if(root == null) return;
//		inorder(root.left);
//		System.out.println(root.data);
//		inorder(root.right);		
//	}
//	
//	
//	class Node{
//		int data;
//		Node left=null;
//		Node right=null;
//		
//		Node(int data){
//			this.data = data;
//		}
//	}
//	
//	public static void main(String[] args) {
//		int[] a = {1,2,3,4,5,6,7}; //assuming a is a sorted array;
//		MinimalTree m = new MinimalTree(a,0,a.length-1);
//		m.inorder();
//	}
//
//}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
}
 
public class MinimalTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
	
	public void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);		
		
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7};
		TreeNode root = new MinimalTree().sortedArrayToBST(a);
		new MinimalTree().inorder(root);		
	}
}