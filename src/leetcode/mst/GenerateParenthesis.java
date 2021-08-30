package leetcode.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * https://leetcode-cn.com/problems/bracket-lcci/
 */
public class GenerateParenthesis {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        generate(sb, n, n);
        return ans;
    }

    void generate(StringBuffer sb, int left, int right) {
        if ((left == 0) && (right == 0)) {
            ans.add(sb.toString());
            return;
        }

        if (right < left) {
            return;
        }

        if (left > 0) {
            sb.append('(');
            generate(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(')');
            generate(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
