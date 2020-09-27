package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.common.TreeNode;

public class ZigzagLevelOrder {
	/**
	 * 103. 二叉树的锯齿形层次遍历
	 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
	 */
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		find(root, 0);
		for (int i = 0; i < ans.size(); i++) {
			if (i % 2 == 1) {
				Collections.reverse(ans.get(i));
			}
		}
		return ans;
	}

	void find(TreeNode root, int i) {
		if (root != null) {
			if (ans.size() <= i) {
				ans.add(new ArrayList<>());
			}
			ans.get(i).add(root.val);
			find(root.left, i + 1);
			find(root.right, i + 1);
		}
	}
}
