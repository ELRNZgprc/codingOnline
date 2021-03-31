package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findSum(root, 0);
    }

    int findSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else {
            if ((root.left == null) && (root.right == null)) {
                return sum * 2 + root.val;
            } else {
                return findSum(root.left, sum * 2 + root.val) + findSum(root.right, sum * 2 + root.val);
            }
        }
    }
}
