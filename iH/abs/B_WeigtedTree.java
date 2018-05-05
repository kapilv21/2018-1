package GI;

public class B_WeigtedTree {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(4);
		tree.right.left = new TreeNode(2);
		tree.right.right = new TreeNode(1);
		System.out.println(WeightedSum(tree));
	}
	static int WeightedSum(TreeNode n){
		if(n == null){
			return 0;
		}
		return n.data + WeightedSum(n.left)+ WeightedSum(n.right);
	}
}



class TreeNode{
	int data; TreeNode left; TreeNode right;
	public TreeNode( int data){
		this.data = data; 
	}
}