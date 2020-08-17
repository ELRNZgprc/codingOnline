package leetcode.problem;

import leetcode.common.TreeNode;

public class isBalanced {
    /**
     * 110
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
}