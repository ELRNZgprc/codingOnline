package leetcode.problem;

import leetcode.common.TreeNode;

public class InvertTree {
    /**
     * 226. 翻转二叉树
     * https://leetcode-cn.com/problems/invert-binary-tree/
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root != null) {
            TreeNode tn = root.left;
            root.left = root.right;
            root.right = tn;
            invert(root.right);
            invert(root.left);
        }
    }
}
