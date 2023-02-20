package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 2096. 从二叉树一个节点到另一个节点每一步的方向
 * https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 */
public class GetDirections {
    StringBuffer sb1 = new StringBuffer();
    StringBuffer sb2 = new StringBuffer();

    // 答案为：最小公共祖先【LCA到startValue的路径 】＋【LCA到destValue的路径】
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode n = lowestCommonAncestor(root, startValue, destValue);
        startPath(n, startValue);
        destPath(n, destValue);
        return sb1.toString() + sb2.toString();
    }

    // 找到公共祖先到startValue的路径，每次都加“U”
    private boolean startPath(TreeNode root, int q) {
        if (root == null) return false;
        if (root.val == q) return true;

        sb1.append("U");
        if (startPath(root.left, q)) return true;
        else sb1.replace(sb1.length() - 1, sb1.length(), "");

        sb1.append("U");
        if (startPath(root.right, q)) return true;
        else sb1.replace(sb1.length() - 1, sb1.length(), "");
        return false;
    }

    // 找到公共祖先到destValue的路径，每次都加“L“或”R“
    private boolean destPath(TreeNode root, int p) {
        if (root == null) return false;
        if (root.val == p) return true;

        sb2.append("L");
        if (destPath(root.left, p)) return true;
        else sb2.replace(sb2.length() - 1, sb2.length(), "");

        sb2.append("R");
        if (destPath(root.right, p)) return true;
        else sb2.replace(sb2.length() - 1, sb2.length(), "");
        return false;
    }

    // 寻找p、q的最小公共祖先
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        if (l == null) return r;
        if (r == null) return l;
        return root;
    }
}
