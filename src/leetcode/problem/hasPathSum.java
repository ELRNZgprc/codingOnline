package leetcode.problem;

import leetcode.common.TreeNode;

public class hasPathSum {
    /**
     * 112
     * https://leetcode-cn.com/problems/path-sum/
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if ((root.right == null) && (root.left == null)) {
            return (sum == root.val);
        }

        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
}
