package leetcode.offer;

import leetcode.common.TreeNode;

public class IsSymmetric {
    /**
     * 剑指 Offer 28. 对称的二叉树
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
