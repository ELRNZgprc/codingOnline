package leetcode.problem;

import leetcode.common.TreeNode;

public class sumOfLeftLeaves {
    /**
     * 404
     * https://leetcode-cn.com/problems/sum-of-left-leaves/
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + ans;
    }
}
