package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.HashSet;

/**
 * 1660. 纠正二叉树
 * https://leetcode.cn/problems/correct-a-binary-tree/
 */
public class CorrectBinaryTree {
    public TreeNode correctBinaryTree(TreeNode root) {
        HashSet<TreeNode> visited = new HashSet<>();
        return dfs(root, visited);
    }

    public TreeNode dfs(TreeNode root, HashSet<TreeNode> visited){
        if(root == null) return null;
        if(visited.contains(root.right)){
            return null;
        }
        visited.add(root);
        root.right = dfs(root.right, visited);
        root.left = dfs(root.left, visited);
        return root;
    }
}
