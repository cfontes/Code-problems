package ojleet;

import java.util.Arrays;

public class PathSum2 {

	public static void main(String[] args) {
		new PathSum2();
	}

	public PathSum2() {
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.createOJTree(Arrays.asList("1", "-2", "-3", "1", "3", "-2", "#", "-1"));
		System.out.println(hasPathSum(root, -1));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root != null) {
			return this.iterate(root, sum, root.val);
		} else {
			return false;
		}
	}

	public boolean iterate(TreeNode root, int sum, int total) {
		if (root.left == null && root.right == null && total == sum) {
			return true;
		}

		if (root.left != null) {
			if (this.iterate(root.left, sum, total + root.left.val))
				return true;
		}

		if (root.right != null) {
			if (this.iterate(root.right, sum, total + root.right.val))
				return true;
		}
		return false;
	}

}
