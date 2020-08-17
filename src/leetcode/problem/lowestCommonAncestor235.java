package leetcode.problem;

import leetcode.common.TreeNode;

public class lowestCommonAncestor235 {
    /**
     * 235
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     */
    public TreeNode lowestCommonAncestor235(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        if ((q.val > root.val) && (p.val > root.val)) {
            return lowestCommonAncestor235(root.right, p, q);
        } else {
            return lowestCommonAncestor235(root.left, p, q);
        }
    }
}
