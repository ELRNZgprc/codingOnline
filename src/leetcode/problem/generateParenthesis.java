package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    /**
     * 22
     * https://leetcode-cn.com/problems/generate-parentheses/
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    public void generate(List<String> ans, String str, int left, int right, int n) {
        if ((left == n) && (right == n)) {
            ans.add(str);
        } else {
            if (left < n) {
                generate(ans, str + "(", left + 1, right, n);
            }
            if (right < left) {
                generate(ans, str + ")", left, right + 1, n);
            }
        }
    }
}
