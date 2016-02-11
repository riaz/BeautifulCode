package practice.ctci.trees;

public class ListOfDepths {
	Node[] depth;
			
	ListOfDepths(int len){
		depth = new Node[len];
		for(int i=0;i<len;i++)
			depth[i] = null;
	}
	
	void getListOfDepth(TreeNode root,int d){
		if(root == null ) return;
		else{
			Node x = new Node(root.val);
			if( depth[d] == null){
				depth[d] = x;				
			}
			else{
				x.next = depth[d];
				depth[d] = x;
			}
		}
		getListOfDepth(root.left,d+1);
		getListOfDepth(root.right,d+1);
		
	}
	
	class Node{
		int data;
		Node next = null;
		
		Node(int data){
			this.data = data;
		}
		
		public void addNode(int data){
			Node n = this;
			while(n!=null)
				n = n.next;
			n = new Node(data);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		TreeNode root = new MinimalTree().sortedArrayToBST(a);
		
		ListOfDepths obj = new ListOfDepths(a.length);
		obj.getListOfDepth(root, 0);
		
		int index = 0;
		for(Node x: obj.depth){
			if(x!=null)
			System.out.print("Depth: " + index++ + " >> ");
			while(x!=null){
				System.out.print(x.data + " ");
				x = x.next;
			}
			System.out.println();
		}
		

	}

}
