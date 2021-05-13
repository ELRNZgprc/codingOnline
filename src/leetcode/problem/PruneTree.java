package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 814. 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if ((root.right == null) && (root.left == null) && (root.val == 0)) {
            return null;
        }
        return root;
    }
}
