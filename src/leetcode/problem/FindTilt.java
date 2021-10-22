package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 563. 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class FindTilt {
    int ans = 0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return ans;
    }

    int getSum(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int left = getSum(tn.left);
        int right = getSum(tn.right);
        ans += Math.abs(left - right);
        return left + right + tn.val;
    }
}
