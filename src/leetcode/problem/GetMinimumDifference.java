package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

import leetcode.common.TreeNode;

public class GetMinimumDifference {
	/**
	 * 530. 二叉搜索树的最小绝对差
	 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
	 */
	List<Integer> list;

	public int getMinimumDifference(TreeNode root) {
		list = new ArrayList<>();
		dfs(root);
		int ans = list.get(1) - list.get(0);
		for (int i = 2; i < list.size(); i++) {
			ans = Math.min(ans, list.get(i) - list.get(i - 1));
		}
		return ans;
	}

	void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.left);
			list.add(root.val);
			dfs(root.right);
		}
	}
}
