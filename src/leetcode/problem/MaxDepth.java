package leetcode.problem;

import leetcode.common.TreeNode;

public class MaxDepth {
    /**
     * 104. 二叉树的最大深度
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
