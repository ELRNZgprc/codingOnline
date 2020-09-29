package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

import leetcode.common.TreeNode;

public class WidthOfBinaryTree {
	/**
	 * 662. 二叉树最大宽度 
	 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
	 */
	List<int[]> list = new ArrayList<>();

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		buildList(root, 0, 1);
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			ans = Math.max(ans, list.get(i)[1] - list.get(i)[0] + 1);
		}
		return ans;
	}

	void buildList(TreeNode root, int h, int n) {
		if (root != null) {
			if (list.size() <= h) {
				int[] ii = new int[] { n, n };
				list.add(ii);
			} else {
				list.get(h)[1] = n;
			}
			buildList(root.left, h + 1, n * 2 - 1);
			buildList(root.right, h + 1, n * 2);
		}
	}
}
