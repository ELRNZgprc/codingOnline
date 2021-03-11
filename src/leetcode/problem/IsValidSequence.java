package leetcode.problem;

import leetcode.common.TreeNode;

public class IsValidSequence {
	/**
	 * 1430. 判断给定的序列是否是二叉树从根到叶的路径
	 * https://leetcode-cn.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
	 */
	public boolean isValidSequence(TreeNode root, int[] arr) {
		return dfs(root, arr, 0);
	}

	public boolean dfs(TreeNode root, int[] arr, int i) {
		if (root == null || i >= arr.length || root.val != arr[i])
			return false;
		if (root.left == root.right && i + 1 == arr.length)
			return true;
		return dfs(root.left, arr, i + 1) || dfs(root.right, arr, i + 1);
	}
}
