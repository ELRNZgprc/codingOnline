package leetcode.problem;

/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        int left = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' && left++ > 0)
                res.append('(');
            if (S.charAt(i) == ')' && --left > 0)
                res.append(')');
        }
        return res.toString();
    }
}
