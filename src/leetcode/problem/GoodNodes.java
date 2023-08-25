package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/
 */
public class GoodNodes {
    public int goodNodes(TreeNode root) {
        int rootVal = root.val;
        return dfs(root, rootVal);
    }

    public int dfs(TreeNode root, int rootVal) {
        if (root == null) {
            return 0;
        }
        if (root.val >= rootVal) {
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        } else {
            return dfs(root.left, rootVal) + dfs(root.right, rootVal);
        }

    }
}