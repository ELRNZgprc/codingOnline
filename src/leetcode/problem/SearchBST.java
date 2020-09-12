package leetcode.problem;

import leetcode.common.TreeNode;

public class SearchBST {
    /**
     * 700. 二叉搜索树中的搜索
     * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
