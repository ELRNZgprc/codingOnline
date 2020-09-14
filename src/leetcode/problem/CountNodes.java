package leetcode.problem;

import leetcode.common.TreeNode;

public class CountNodes {
    /**
     * 222. 完全二叉树的节点个数
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
