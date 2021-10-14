package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 0 || depth == 1) {
            TreeNode t = new TreeNode(val);
            if (depth == 1) t.left = root;
            else t.right = root;
            return t;
        }
        if (root != null && depth > 1) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        return root;
    }
}
