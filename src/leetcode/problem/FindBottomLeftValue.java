package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * https://leetcode-cn.com/problems/LwUNpT/
 */
public class FindBottomLeftValue {
    int depth = 0;
    int left = 0;

    public int findBottomLeftValue(TreeNode root) {
        findLeft(root, 1);
        return left;
    }

    public void findLeft(TreeNode tr, int dep) {
        if (tr != null) {
            if (dep > depth) {
                depth = dep;
                left = tr.val;
            }
            findLeft(tr.left, dep + 1);
            findLeft(tr.right, dep + 1);
        }
    }
}
