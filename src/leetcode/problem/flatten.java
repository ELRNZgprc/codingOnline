package leetcode.problem;

import leetcode.common.TreeNode;

public class flatten {
    /**
     * 114
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode treeNode = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = treeNode;
    }
}
