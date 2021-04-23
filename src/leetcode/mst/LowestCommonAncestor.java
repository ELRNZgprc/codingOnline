package leetcode.mst;

import leetcode.common.TreeNode;

/**
 * 面试题 04.08. 首个共同祖先
 * https://leetcode-cn.com/problems/first-common-ancestor-lcci/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root == null) || (root.val == p.val) || (root.val == q.val)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if ((left != null) && (right != null)) {
            return root;
        }
        if ((left == null) && (right != null)) {
            return right;
        }
        return left;
    }
}
