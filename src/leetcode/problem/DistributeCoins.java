package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 979. 在二叉树中分配硬币
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/
 */
public class DistributeCoins {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        moveCoin(root);
        return ans;
    }

    public int moveCoin(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        tn.val += moveCoin(tn.left);
        tn.val += moveCoin(tn.right);
        ans += Math.abs(tn.val - 1);
        return tn.val - 1;
    }
}
