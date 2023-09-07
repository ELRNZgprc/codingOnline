package leetcode.problem;

import leetcode.common.Node;

/**
 * 559. N 叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/description/
 */
public class MaxDepth559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
