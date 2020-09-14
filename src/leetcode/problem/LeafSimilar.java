package leetcode.problem;

import leetcode.common.TreeNode;

public class LeafSimilar {
    /**
     * 872. 叶子相似的树
     * https://leetcode-cn.com/problems/leaf-similar-trees/
     */
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        findLeaves(root1, 1);
        findLeaves(root2, 2);
        return sb1.toString().equals(sb2.toString());
    }

    void findLeaves(TreeNode root, int n) {
        if (root != null) {
            if ((root.right == null) && (root.left == null)) {
                if (n == 1) {
                    sb1.append(root.val + " ");
                } else {
                    sb2.append(root.val + " ");
                }
            }
            findLeaves(root.left, n);
            findLeaves(root.right, n);
        }
    }
}
