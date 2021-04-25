package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 897. 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST {
    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = increasingBST(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            root.left = null;
            head = node;
            while (node.right != null)
                node = node.right;
            node.right = root;
            return increasingBST(head);
        } else {
            return root;
        }
    }

}
