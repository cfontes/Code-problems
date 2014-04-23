package ojleet;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public TreeNode(TreeNode left, int element, TreeNode right) {
		this.val = element;
		this.left = left;
		this.right = right;
	}
}