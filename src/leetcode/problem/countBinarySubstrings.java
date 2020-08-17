package leetcode.problem;

public class countBinarySubstrings {
    /**
     * 696
     * https://leetcode-cn.com/problems/count-binary-substrings/
     */
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int[] num = {0, 0};
        num[s.charAt(0) - '0']++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                num[s.charAt(i) - '0']++;
            } else {
                ans += Math.min(num[0], num[1]);
                num[s.charAt(i) - '0'] = 1;
            }
            if (i == s.length() - 1) {
                ans += Math.min(num[0], num[1]);
            }
        }
        return ans;
    }
}
