package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 687. 最长同值路径
 * https://leetcode.cn/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMax(root);
        return res;
    }

    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findMax(node.left);
        int right = findMax(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }

        res = Math.max(res, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
