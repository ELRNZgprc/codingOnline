package leetcode.problem;

import leetcode.common.TreeNode;

public class LongestConsecutive {
    /**
     * 298. 二叉树最长连续序列
     * https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence/
     */
    int max;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        work(root, 1);
        return max;
    }

    void work(TreeNode root, int i) {
        if (i > max) {
            max = i;
        }
        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                work(root.right, i + 1);
            } else {
                work(root.right, 1);
            }
        }
        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                work(root.left, i + 1);
            } else {
                work(root.left, 1);
            }
        }
    }
}
