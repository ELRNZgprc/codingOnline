package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1372. 二叉树中的最长交错路径
 * https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class LongestZigZag {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true);
        return max;
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int r = dfs(root.right, false);
        int l = dfs(root.left, true);
        max = Math.max(max, Math.max(l, r));
        if (isLeft) {
            return r + 1;
        } else {
            return l + 1;
        }
    }
}
