package leetcode.problem;

import java.util.Stack;

/**
 * 255. 验证前序遍历序列二叉搜索树
 * https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s = new Stack<>();
        int pre = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val <= pre) {
                return false;
            }
            while (!s.isEmpty() && (val > s.peek())) {
                pre = s.pop();
            }
            s.push(val);
        }
        return true;
    }
}
