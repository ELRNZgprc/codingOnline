package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        }
        if ((p == null) || (q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
