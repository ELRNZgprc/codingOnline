package leetcode.lcp;

import leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 44. 开幕式焰火
 * https://leetcode-cn.com/problems/sZ59z6/
 */
public class NumColor {
    Set<Integer> list = new HashSet<>();

    public int numColor(TreeNode root) {
        checkColor(root);
        return list.size();
    }

    void checkColor(TreeNode node) {
        if (node != null) {
            list.add(node.val);
            checkColor(node.left);
            checkColor(node.right);
        }
    }
}
