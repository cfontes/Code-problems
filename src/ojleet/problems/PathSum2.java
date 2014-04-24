package ojleet.problems;

import java.util.ArrayList;
import java.util.Arrays;

import ojleet.helpers.BinaryTree;
import ojleet.helpers.TreeNode;

public class PathSum2 {

	public static void main(String[] args) {
		new PathSum2();
	}

	public PathSum2() {
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.createOJTree(Arrays.asList("1", "-2", "-3", "1", "3", "-2", "#", "-1"));
		System.out.println(pathSum(root, -1));
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if (root != null) {
			ArrayList<Integer> result = findSums(root, sum, root.val);
			
			
			Fala fazer o recursivo dar mais de uma solucao
			
			
			return new ArrayList<ArrayList<Integer>>();
		}
		return new ArrayList<ArrayList<Integer>>();
	}

	public ArrayList<Integer> findSums(TreeNode root, int sum, int total) {				
		if(root.left == null && root.right == null && total == sum){
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(root.val);
			return path;
		}else if(root.left == null && root.right == null && total != sum){
			return null;
		}

		if(root.left != null){
			ArrayList<Integer> left = findSums(root.left, sum, total + root.left.val);
			if(left != null){
				left.add(root.left.val);
				return left;
			}
		}

		if(root.right != null){
			ArrayList<Integer> right = findSums(root.right, sum, total + root.right.val);
			if(right != null){
				right.add(root.right.val);
				return right;
			}
		}

		return null;
	}

}
