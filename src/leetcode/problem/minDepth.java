package leetcode.problem;

import leetcode.common.TreeNode;

public class minDepth {
    /**
     * 111
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
