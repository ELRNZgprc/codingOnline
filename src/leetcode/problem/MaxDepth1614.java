package leetcode.problem;

/**
 * 1614. 括号的最大嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaxDepth1614 {
    public int maxDepth(String s) {
        int ans = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                if (left > ans) {
                    ans = left;
                }
            } else if (c == ')') {
                left--;
            }
        }
        return ans;
    }
}
