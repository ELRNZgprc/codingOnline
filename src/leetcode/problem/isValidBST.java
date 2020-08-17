package leetcode.problem;

import leetcode.common.TreeNode;

public class isValidBST {
    /**
     * 98
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValid(TreeNode p, long min, long max) {
        if (p == null) {
            return true;
        }
        if ((p.val <= min) || (p.val >= max)) {
            return false;
        }
        return (isValid(p.left, min, p.val) && isValid(p.right, p.val, max));
    }
}
