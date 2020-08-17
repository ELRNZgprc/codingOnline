package leetcode.problem;

public class titleToNumber {
    /**
     * 171
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 26;
            ans += s.charAt(i) - 'A' + 1;
        }
        return ans;
    }
}
