package leetcode.mst;

import leetcode.common.TreeNode;

/**
 * 面试题 04.10. 检查子树
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 */
public class CheckSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        if (t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return dfs(t1, t2);
        }

        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean dfs(TreeNode t1, TreeNode t2) {
        if ((t1 == null) && (t2 == null)) {
            return true;
        }

        if ((t1 == null) || (t2 == null)) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return dfs(t1.right, t2.right) && dfs(t1.left, t2.left);
    }
}
