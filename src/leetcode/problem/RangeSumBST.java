package leetcode.problem;

import leetcode.common.TreeNode;

public class RangeSumBST {
    /**
     *938. 二叉搜索树的范围和
     * https://leetcode-cn.com/problems/range-sum-of-bst/
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
        }
    }
}
