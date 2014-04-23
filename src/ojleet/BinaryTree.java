package ojleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	public BinaryTree() {
	}

	public BinaryTree(List<Integer> items) {
		this();
		create(items);
	}

	public TreeNode create(List<Integer> items) {
		TreeNode root = new TreeNode(null, items.get(0), null);

		final Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		final int half = items.size() / 2;

		for (int i = 0; i < half; i++) {
			if (items.get(i) != null) {
				final TreeNode current = queue.poll();
				final int left = 2 * i + 1;
				final int right = 2 * i + 2;

				if (items.get(left) != null) {
					current.left = new TreeNode(null, items.get(left), null);
					queue.add(current.left);
				}
				if (right < items.size() && items.get(right) != null) {
					current.right = new TreeNode(null, items.get(right), null);
					queue.add(current.right);
				}
			}
		}
		return root;
	}

	public TreeNode createOJTree(List<String> values) {
		ArrayList<String> items = new ArrayList<String>(values);

		Integer rootValue = Integer.parseInt(items.remove(0));
		if (rootValue != null) {
			TreeNode root = new TreeNode(null, rootValue, null);

			final Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);

			while (!items.isEmpty()) {
				final TreeNode current = queue.poll();
				String itemL = items.remove(0);
				if (!itemL.equals("#")) {
					Integer leftVal = Integer.parseInt(itemL);
					if (leftVal != null) {
						current.left = new TreeNode(null, leftVal, null);
						queue.add(current.left);
					}
				}

				if (!items.isEmpty()) {
					String itemR = items.remove(0);
					if (!itemR.equals("#")) {
						Integer rightVal = Integer.parseInt(itemR);
						if (rightVal != null) {
							current.right = new TreeNode(null, rightVal, null);
							queue.add(current.right);
						}
					}
				}
			}
			return root;
		} else {
			return null;
		}
	}
}