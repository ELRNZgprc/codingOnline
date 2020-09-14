package leetcode.offer;

import leetcode.common.TreeNode;

public class LowestCommonAncestor {
    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        if ((q.val > root.val) && (p.val > root.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
