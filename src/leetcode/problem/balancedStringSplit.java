package leetcode.problem;

public class balancedStringSplit {
    /**
     * 1221
     * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
     */
    public int balancedStringSplit(String s) {
        int ans = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                l++;
            }
            if (s.charAt(i) == 'L') {
                l--;
            }
            if (l == 0) {
                ans++;
            }
        }
        return ans;
    }
}
