package ojleet;

import java.util.Arrays;

public class PathSum {

	/**
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {
		new PathSum();
	}

	public PathSum() {
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.createOJTree(Arrays.asList("1", "-2", "-3", "1", "3", "-2", "#", "-1"));
		System.out.println(hasPathSum(root, -1));
	}

	/**
	 * Validates if the tree is not null
	 * 
	 * @param root
	 * @param sum
	 * @return
	 * @author Cristiano
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root != null) {
			return this.searhForSum(root, sum, root.val);
		} else {
			return false;
		}
	}

	/**
	 * Searches the tree for root-to-leaf path that sums to the parameter sum
	 * 
	 * @param root
	 *            root of the tree
	 * @param sum
	 *            number to search for a sum path
	 * @param total
	 *            total currently summed up, in first iteration should be the root node value
	 * @return true if found a valid path, false if not
	 * @author Cristiano
	 */
	public boolean searhForSum(TreeNode root, int sum, int total) {
		if (root.left == null && root.right == null && total == sum) {
			return true;
		}

		if (root.left != null) {
			if (this.searhForSum(root.left, sum, total + root.left.val))
				return true;
		}

		if (root.right != null) {
			if (this.searhForSum(root.right, sum, total + root.right.val))
				return true;
		}
		return false;
	}

}
