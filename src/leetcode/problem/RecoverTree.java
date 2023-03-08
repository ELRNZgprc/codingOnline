package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 99. 恢复二叉搜索树
 * https://leetcode.cn/problems/recover-binary-search-tree/
 */
public class RecoverTree {
    TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
