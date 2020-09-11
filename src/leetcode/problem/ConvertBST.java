package leetcode.problem;

import leetcode.common.TreeNode;

public class ConvertBST {
    /**
     * 538. 把二叉搜索树转换为累加树
     * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
     */
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val = root.val + num;
            num = root.val;
            convertBST(root.left);
            return root;
        }
        return null;
    }
}
