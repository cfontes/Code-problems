package ojleet.problems;

import java.util.ArrayList;
import java.util.Stack;

import ojleet.helpers.BinaryTree;
import ojleet.helpers.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {

	/**
	 * Couldn't make this one work yet...
	 * 
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {
		new BinaryTreeLevelOrderTraversal2();
	}

	public BinaryTreeLevelOrderTraversal2() {

		int x = 5;
		int i = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (i <= x) {
			list.add(i);
			i++;
		}
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.create(list);
		this.printTree(root);

	}

	/**
	 * Prints the tree to console
	 * 
	 * @param root
	 * @author Cristiano
	 */
	public void printTree(TreeNode root) {
		ArrayList<ArrayList<Integer>> treeOutput;
		treeOutput = levelOrderBottom(root);
		for (ArrayList<Integer> level : treeOutput) {
			System.out.print("[");
			for (Integer leaf : level) {
				System.out.print(leaf + ",");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	/**
	 * Transforms a tree into a inverse tree as an arraylist of levels
	 * 
	 * @param root
	 *            of the tree
	 * @return inversed tree as an ArrayList
	 * @author Cristiano
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> node = new ArrayList<Integer>();

		this.iterateAll(root, stack);

		while (!stack.empty()) {
			if (stack.peek() != null) {
				node.add(stack.pop());
				if (!stack.isEmpty()) {
					if (stack.peek() != null) {
						tree.add(node);
						node = new ArrayList<Integer>();
					} else {
						stack.pop();
						if (!stack.isEmpty()) {
							if (stack.peek() != null) {
								tree.add(node);
								node = new ArrayList<Integer>();
							}
						}
					}
				} else {
					tree.add(node);
				}
			} else {
				stack.pop();
			}
		}
		return tree;
	}

	/**
	 * Iterate the tree turning it into a stack.
	 * 
	 * @param root
	 *            Root node of the tree
	 * @param stack
	 *            with the branches already read
	 * @return a stack with all branches
	 * @author Cristiano
	 */
	public Stack<Integer> iterateAll(TreeNode root, Stack<Integer> stack) {
		if (root != null) {
			stack.push(root.val);
			if (root.right != null) {
				iterateAll(root.right, stack);
			} else {
				stack.push(null);
			}

			if (root.left != null) {
				iterateAll(root.left, stack);
			} else {
				stack.push(null);
			}
		}
		return stack;
	}
}
