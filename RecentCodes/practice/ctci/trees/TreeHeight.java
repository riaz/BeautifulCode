package practice.ctci.trees;

public class TreeHeight {
	//program to get the height of a tree
	
	public int getHeight(TreeNode root){
		if (root == null) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		TreeNode root = new MinimalTree().sortedArrayToBST(a);
		
		//expected: 3
		System.out.println("The height of the tree is: " + new TreeHeight().getHeight(root));	
		
	}

}
