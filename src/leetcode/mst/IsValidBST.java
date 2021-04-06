package leetcode.mst;

import leetcode.common.TreeNode;

/**
 * 面试题 04.05. 合法二叉搜索树
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if ((root.val >= max) || (root.val <= min)) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
