package leetcode.problem;

import leetcode.common.TreeNode;

public class MaxPathSum {
    /**
     * 124. 二叉树中的最大路径和
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }

    int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findMax(root.left);
        int right = findMax(root.right);
        max = Math.max(left + right + root.val, max);
        return Math.max(root.val + Math.max(left, right), 0);
    }
}
