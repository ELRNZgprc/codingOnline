package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1145. 二叉树着色游戏
 * https://leetcode.cn/problems/binary-tree-coloring-game/
 */
public class BtreeGameWinningMove {
    private int left = 0;
    private int right = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        return getNum(root, x) / 2 < Math.max(Math.max(left, right), n - (left + right + 1));
    }

    private int getNum(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int r = getNum(node.right, x);
        int l = getNum(node.left, x);
        if (node.val == x) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
