package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1080. 根到叶路径上的不足节点
 * https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class SufficientSubset {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return root.left == null && root.right == null ? null : root;
    }
}

