package leetcode.problem;

import leetcode.common.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode.cn/problems/construct-string-from-binary-tree/
 */
public class Tree2str {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        doTree2str(t, sb);
        return sb.toString();
    }

    private void doTree2str(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append('(');
                doTree2str(t.left, sb);
                sb.append(')');
                if (t.right != null) {
                    sb.append('(');
                    doTree2str(t.right, sb);
                    sb.append(')');
                }
            }
        }
    }
}
