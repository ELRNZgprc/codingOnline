package leetcode.problem;

/**
 * 2414. 最长的字母序连续子字符串的长度
 * https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/
 */
public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 1;
        int current = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }
            ans = Math.max(ans, current);
        }
        return ans;
    }
}
