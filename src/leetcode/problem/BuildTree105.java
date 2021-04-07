package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree105 {
    int count = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int low, int high) {
        if (low > high) {
            return null;
        }
        int key = 0;
        for (int i = low; i <= high; i++) {
            if (inorder[i] == preorder[count]) {
                key = i;
                break;
            }
        }
        TreeNode head = new TreeNode(preorder[count++]);
        head.left = dfs(preorder, inorder, low, key - 1);
        head.right = dfs(preorder, inorder, key + 1, high);
        return head;
    }
}
