package leetcode.problem;

import leetcode.common.TreeNode;

public class MinCameraCover {
	/**
	 * 968. 监控二叉树
	 * https://leetcode-cn.com/problems/binary-tree-cameras/
	 */
	int ans = 0;

	public int minCameraCover(TreeNode root) {
		if (root == null)
			return 0;
		if (dfs(root) == 2)
			ans++;
		return ans;
	}

	int dfs(TreeNode node) {
		if (node == null)
			return 1;
		int left = dfs(node.left), right = dfs(node.right);
		if (left == 2 || right == 2) {
			ans++;
			return 0;
		} else if (left == 0 || right == 0) {
			return 1;
		} else
			return 2;
	}
}
