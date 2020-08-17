package leetcode.problem;

import leetcode.common.TreeNode;

public class maxProduct {
    /**
     * 1339
     * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
     */
    public int maxProduct(TreeNode root) {
        int sum = getSum(root);
        pre(root, sum);
        int k = 1000000007;
        long c = a % k;
        long d = b % k;
        return (int) ((a / k + b / k + a / k * d + b / k * c) % k + c * d % k) % k;
    }

    int getSum(TreeNode p) {
        if (p != null) {
            p.val = p.val + getSum(p.left) + getSum(p.right);
        } else {
            return 0;
        }
        return p.val;
    }

    long a = Integer.MAX_VALUE;
    long b = Integer.MIN_VALUE;

    void pre(TreeNode p, int sum) {
        if (p != null) {
            if (Math.abs(a - b) > Math.abs(sum - 2 * p.val)) {
                a = sum - p.val;
                b = p.val;
            }
            pre(p.left, sum);
            pre(p.right, sum);
        }
    }
}
