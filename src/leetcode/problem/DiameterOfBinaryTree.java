package leetcode.problem;

import leetcode.common.TreeNode;

public class DiameterOfBinaryTree {
    /**
     * 543. 二叉树的直径
     * https://leetcode-cn.com/problems/diameter-of-binary-tree/
     */
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dps(root);
        return max;
    }

    int dps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dps(root.left);
        int right = dps(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
