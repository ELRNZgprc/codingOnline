package leetcode.problem;

import leetcode.common.TreeNode;

public class IsCousins {
	/**
	 * 993. 二叉树的堂兄弟节点
	 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
	 */
	int xpar, xdep, ypar, ydep;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root.left, 1, x, y, root.val);
		dfs(root.right, 1, x, y, root.val);
		return (xpar != ypar) && (xdep == ydep);
	}

	public void dfs(TreeNode node, int dep, int x, int y, int par) {
		if (node == null) {
			return;
		}
		if (node.val == x) {
			xpar = par;
			xdep = dep;
		} else if (node.val == y) {
			ypar = par;
			ydep = dep;
		} else {
			dfs(node.left, dep + 1, x, y, node.val);
			dfs(node.right, dep + 1, x, y, node.val);
		}
	}
}
