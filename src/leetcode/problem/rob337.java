package leetcode.problem;

import leetcode.common.TreeNode;

public class rob337 {
    /**
     * 337
     * https://leetcode-cn.com/problems/house-robber-iii/
     */
    public int rob(TreeNode root) {
        return Math.max(work337(root, false), work337(root, true));
    }

    int work337(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            return work337(root.left, false) + work337(root.right, false) + root.val;
        }
        return Math.max(work337(root.left, false), work337(root.left, true)) + Math.max(work337(root.right, false), work337(root.right, true));
    }
}
