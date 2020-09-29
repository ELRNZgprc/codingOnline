package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

import leetcode.common.TreeNode;

public class PostorderTraversal {
	/**
	 * 145. 二叉树的后序遍历
	 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
	 */
	List<Integer> ans = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		doPost(root);
		return ans;
	}

	void doPost(TreeNode root) {
		if (root != null) {
			doPost(root.left);
			doPost(root.right);
			ans.add(root.val);
		}
	}
}
