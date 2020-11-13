package leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.common.TreeNode;

public class RightSideView {
	/**
	 * 199. 二叉树的右视图
	 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (i == size - 1) {
					ans.add(node.val);
				}
			}
		}
		return ans;
	}
}
