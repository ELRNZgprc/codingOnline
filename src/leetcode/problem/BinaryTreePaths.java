package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * 257. 二叉树的所有路径
     * https://leetcode-cn.com/problems/binary-tree-paths/
     */
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        findPaths(root, "");
        return ans;
    }

    void findPaths(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += root.val;
        if ((root.left == null) && (root.right == null)) {
            ans.add(s);
        }
        findPaths(root.left, s + "->");
        findPaths(root.right, s + "->");
    }
}
