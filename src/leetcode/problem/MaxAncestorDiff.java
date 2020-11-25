package leetcode.problem;

import leetcode.common.TreeNode;

public class MaxAncestorDiff {
	/**
	 * 1026. 节点与其祖先之间的最大差值
	 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
	 */
	int ans;

	public int maxAncestorDiff(TreeNode root) {
		ans = 0;
		findMax(root, root.val, root.val);
		return ans;
	}

	void findMax(TreeNode root, int min, int max) {
		if (root != null) {
			ans = Math.max(ans, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
			findMax(root.left, Math.min(min, root.val), Math.max(max, root.val));
			findMax(root.right, Math.min(min, root.val), Math.max(max, root.val));
		}
	}
}
