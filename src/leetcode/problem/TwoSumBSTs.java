package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1214. 查找两棵二叉搜索树之和
 * https://leetcode-cn.com/problems/two-sum-bsts/
 */
public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if ((root1 == null) || (root2 == null)) {
            return false;
        }
        return isFound(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    private boolean isFound(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        } else if (root.val < val) {
            return isFound(root.right, val);
        } else {
            return isFound(root.left, val);
        }
    }
}
