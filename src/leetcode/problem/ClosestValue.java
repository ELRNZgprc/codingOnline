package leetcode.problem;

import leetcode.common.TreeNode;

public class ClosestValue {
    /**
     * 270. 最接近的二叉搜索树值
     * https://leetcode-cn.com/problems/closest-binary-search-tree-value/
     */
    int closest;

    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        findTarget(root, target);
        return closest;
    }

    void findTarget(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            closest = root.val;
            return;
        }
        if (Math.abs(closest - target) > Math.abs(root.val - target)) {
            closest = root.val;
        }
        if (root.val > target) {
            findTarget(root.left, target);
        } else {
            findTarget(root.right, target);
        }
    }
}
