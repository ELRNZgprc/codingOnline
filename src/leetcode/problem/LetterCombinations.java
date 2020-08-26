package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    /**
     * 17. 电话号码的字母组合
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     */
    List<String> ans;
    StringBuilder sb;
    String[] c = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        sb = new StringBuilder();
        dps(digits, 0);
        return ans;
    }

    void dps(String digits, int i) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        for (char c : c[digits.charAt(i) - '2'].toCharArray()) {
            sb.append(c);
            dps(digits, i + 1);
            sb.deleteCharAt(i);
        }
    }
}
