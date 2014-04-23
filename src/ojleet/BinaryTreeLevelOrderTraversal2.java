package ojleet;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal2 {

	/**
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {
		new BinaryTreeLevelOrderTraversal2();
	}

	public BinaryTreeLevelOrderTraversal2() {
		ArrayList<ArrayList<Integer>> treeOutput;
		int x = 5;
		int i = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (i <= x) {
			list.add(i);
			i++;
		}
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.create(list);
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
