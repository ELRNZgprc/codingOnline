package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
